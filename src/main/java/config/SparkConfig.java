package config;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SparkConfig {
	public void startSparkReporter(ExtentReports extent) throws IOException {
		File sparkFolder = new File("sparkReports/");
		if(!(sparkFolder.exists())) { sparkFolder.mkdirs();}; 
		//Creating HTML Report
		ExtentSparkReporter spark = new ExtentSparkReporter(sparkFolder+"/Spark.html");
		spark.loadXMLConfig("xmlfiles/extent-config.xml");
		spark.config().setJs("var logo = document.getElementsByClassName('logo'); logo.style = 'background-image: url('https://qalified.com/wp-content/uploads/2020/06/logo-qalified.svg')");
		extent.attachReporter(spark);
	}

}
