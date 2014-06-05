package br.com.fluentcode.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	
	private WebDriver driver;
	
	public GooglePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void search(String text){
		// Enter the string
		WebElement campoDeTexto = driver.findElement(By.name("q"));
		campoDeTexto.sendKeys(text);

		// Submit the form
		campoDeTexto.submit();
	}
	

}
