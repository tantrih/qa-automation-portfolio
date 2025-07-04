package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilityclass {
	
	public static String readPFData(String key) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//TestData//config.properties");
		Properties prop=new Properties();
		prop.load(file);
		String value=prop.getProperty(key);
		return value;
	}
	
	public static void captureSS(String TCID, WebDriver driver) throws IOException {
		File dest=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src=new File(System.getProperty("user.dir")+"/FaildTestcaseScreenshot/FaildeTestcase_"+TCID+".jpg");
		FileHandler.copy(dest, src);
	}
}
