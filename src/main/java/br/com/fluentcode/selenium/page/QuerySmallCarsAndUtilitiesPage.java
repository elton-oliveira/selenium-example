package br.com.fluentcode.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.fluentcode.selenium.form.QuerySmallCarsAndUtilitiesForm;
import br.com.fluentcode.selenium.infra.JavaScriptProcess;

public class QuerySmallCarsAndUtilitiesPage {

	private WebDriver driver;
	private JavaScriptProcess jProcess;

	public QuerySmallCarsAndUtilitiesPage(WebDriver driver) {
		this.driver = driver;
		this.jProcess = new JavaScriptProcess(driver);
	}
	
	public void query(QuerySmallCarsAndUtilitiesForm form){
		
		Select cbReferencia = new Select(driver.findElement(By.id("ddlTabelaReferencia")));
		cbReferencia.selectByVisibleText(form.getReferencia());
		
		driver.findElement(By.id("txtCodFipe")).sendKeys(form.getCodigoFipe());
		
		driver.findElement(By.id("btnCodFipe")).click();
		
		Select cbAnoModelo = new Select(driver.findElement(By.id("ddlAnoValor")));
		jProcess.waitToBeVisibility(By.xpath("//select[@id='ddlAnoValor']/option[text()='"+form.getAnoModelo()+"']"));
		cbAnoModelo.selectByVisibleText(form.getAnoModelo());
		
		jProcess.waitToBeVisibility(By.id("pnlResultado"));
		
	}

}
