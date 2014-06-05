package br.com.fluentcode.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.fluentcode.selenium.page.GooglePage;

public class GoogleSearchTest {

	private WebDriver driver;

	@Before
	public void begin() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		// Go to the Google home page
		driver.get("http://www.google.com.br/");
	}

	@Test
	public void shouldSearchSelenium() {
		GooglePage googlePage = new GooglePage(driver);
		googlePage.search("Selenium");
	}

	@After
	public void end() {
		driver.quit();
	}

}
