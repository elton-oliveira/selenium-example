package br.com.fluentcode.selenium.infra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptProcess {

	private WebDriverWait wait;

	public JavaScriptProcess(WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
	}

	public void waitJQueryCompleted() {
		wait.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				
				try{

				boolean jQueryActive = (Boolean) ((JavascriptExecutor) driver)
						.executeScript("return jQuery.active == 0");

				return jQueryActive;
				
				}catch (Exception e) {
					// Proceeds normally
					return true;
				}

			}

		});

	}

	public void waitToBeVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitToBeClickable(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
}
