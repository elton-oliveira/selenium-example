package br.com.fluentcode.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FipeHomePage {
	
	private WebDriver driver;
	
	public FipeHomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public FipeHomePage visit(){
		driver.get("http://www.fipe.org.br");
		return this;
	}
	
	public QuerySmallCarsAndUtilitiesPage querySmallCarsAndUtilities(){
		driver.switchTo().frame(driver.findElement(By.id("fconteudo")));
		driver.findElement(By.linkText("Tabela de Preços Médios de Veículos")).click();
		driver.findElement(By.linkText("Consulta de Carros e Utilitários Pequenos")).click();
		return new QuerySmallCarsAndUtilitiesPage(driver);
	}

}
