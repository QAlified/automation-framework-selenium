package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVHandler {
	
	private String filePath;
	private Reader fileReader;
	private Iterable<CSVRecord> records;

	
	public CSVHandler(String fileToPath) throws FileNotFoundException {
		this.setFilePath(fileToPath);
		this.setFileReader(new FileReader(fileToPath));
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Reader getFileReader() {
		return fileReader;
	}

	public void setFileReader(Reader fileReader) {
		this.fileReader = fileReader;
	}
	
	public Iterable<CSVRecord> getRecords() {
		return records;
	}

	public void setRecords(Iterable<CSVRecord> records) {
		this.records = records;
	}


	public void loadDataDefiningHeaders(String ...headers) throws IOException {
		this.setRecords(CSVFormat.RFC4180.withHeader(headers).parse(this.getFileReader()));
	}
		
	public void loadDataFromCSVWithHeader() throws IOException {
		this.setRecords(CSVFormat.RFC4180.withFirstRecordAsHeader().parse(this.getFileReader()));
	}
	
	public void loadDataWithDelimiter(char delimiter) throws IOException {
		this.setRecords(CSVFormat.RFC4180.withDelimiter(delimiter).parse(this.getFileReader()));
	}
	

}
