package br.com.fluentcode.selenium.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.fluentcode.selenium.form.QuerySmallCarsAndUtilitiesForm;
import br.com.fluentcode.selenium.infra.WebDriverFactory;
import br.com.fluentcode.selenium.page.FipeHomePage;
import br.com.fluentcode.selenium.page.QuerySmallCarsAndUtilitiesPage;

public class FipeSystemTest {

	private WebDriver driver;
	private FipeHomePage fipeHomePage;

	@Before
	public void begin() {
		this.driver = WebDriverFactory.getHtmlUnitDriver();
		this.fipeHomePage = new FipeHomePage(driver);
		fipeHomePage.visit();
	}
	
	@After
	public void end() {
		driver.quit();
	}

	@Test
	public void shouldQuerySmallCar() {
		QuerySmallCarsAndUtilitiesPage querySmallCarsAndUtilities = fipeHomePage.querySmallCarsAndUtilities();
		QuerySmallCarsAndUtilitiesForm form = new QuerySmallCarsAndUtilitiesForm();
		form.setReferencia("2014 / Mai");
		form.setCodigoFipe("014079-1");
		form.setAnoModelo("Zero KM a gasolina");
		querySmallCarsAndUtilities.query(form);
		assertThat(driver.getPageSource(), containsString("R$ 51.954,00") );
	}
	
}
