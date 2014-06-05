package br.com.fluentcode.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Go to the Google home page
		driver.get("http://www.google.com.br/");
		
		// Enter de string 'Selenium'
        WebElement campoDeTexto = driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Selenium");

        // Submit the form
        campoDeTexto.submit();
         
        driver.quit();
	}

}
