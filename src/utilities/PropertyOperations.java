package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class PropertyOperations {
	
	private String propertyFilePath = "src\\utilities\\PropertiesFile.properties";
	
	public String getPropertyValue (String input){
		File propFile = new File(propertyFilePath);
		FileInputStream inputFile = null;
		Properties prop = new Properties();
		try {
			inputFile = new FileInputStream(propFile);
			prop.load(inputFile);
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			Reporter.log("Properties File Load not successful which is present at location: "+propertyFilePath);
		}
		
		return prop.getProperty(input);	
	}
	
	
}
