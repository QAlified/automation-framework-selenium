package exceptions;

public class NoSuchPropertyFileException extends Exception {



	public NoSuchPropertyFileException(String fileName) {
		super("Property file not found: '" + fileName + "'");
	}

}
