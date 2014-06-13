package br.com.fluentcode.selenium.infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	/**
	 * This is currently the fastest and most lightweight implementation of
	 * WebDriver. As the name suggests, this is based on HtmlUnit. HtmlUnit is a
	 * java based implementation of a WebBrowser without a GUI.
	 */
	public static WebDriver getHtmlUnitDriver() {
		return new HtmlUnitDriver(true);
	}

	public static WebDriver getInternetExplorerDriver() {
		System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

	public static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		return new ChromeDriver();
	}

}
