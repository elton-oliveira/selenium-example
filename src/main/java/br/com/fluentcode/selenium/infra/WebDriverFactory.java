package br.com.fluentcode.selenium.infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
	
	
	public static WebDriver getInternetExplorerDriver(){
		System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
		return new InternetExplorerDriver();
	}
	
	public static WebDriver getChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		return new ChromeDriver();
	}
	
}
