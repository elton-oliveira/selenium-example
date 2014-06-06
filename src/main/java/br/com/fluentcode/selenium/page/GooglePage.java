package br.com.fluentcode.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// The Page Object pattern
public class GooglePage {
	
	private WebDriver driver;
	
	public GooglePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void search(String text){
		// Enter the string
		WebElement textField = driver.findElement(By.name("q"));
		textField.sendKeys(text);

		// Submit the form
		textField.submit();
	}
	

}
