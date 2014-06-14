package br.com.fluentcode.selenium.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import br.com.fluentcode.selenium.form.QuerySmallCarsAndUtilitiesForm;
import br.com.fluentcode.selenium.infra.WebDriverFactory;
import br.com.fluentcode.selenium.page.FipeHomePage;
import br.com.fluentcode.selenium.page.QuerySmallCarsAndUtilitiesPage;

@RunWith(Parameterized.class)
public class FipeSystemTest {

	private WebDriver driver;
	private FipeHomePage fipeHomePage;
	
	private String referencia;
	private String codigoFipe;
	private String anoModelo;
	private String expected;
	
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
	
	// Data-Driven Testing
	@Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
					{ "2014 / Mai", "014079-1", "Zero KM a gasolina", "R$ 51.954,00" },
					{ "2014 / Mai", "015098-3", "Zero KM a gasolina", "R$ 77.385,00" },
					{ "2014 / Mai", "013031-1", "Zero KM a gasolina", "R$ 128.000,00" } 
			});
	}
	
	// Constructor
	public FipeSystemTest(String referencia, String codigoFipe, String anoModelo, String expected){
		this.referencia = referencia;
		this.codigoFipe = codigoFipe;
		this.anoModelo = anoModelo;
		this.expected = expected;
		
	}

	@Test
	public void shouldQuerySmallCar() {
		QuerySmallCarsAndUtilitiesPage querySmallCarsAndUtilities = fipeHomePage.querySmallCarsAndUtilities();
		QuerySmallCarsAndUtilitiesForm form = new QuerySmallCarsAndUtilitiesForm();
		form.setReferencia(referencia);
		form.setCodigoFipe(codigoFipe);
		form.setAnoModelo(anoModelo);
		querySmallCarsAndUtilities.query(form);
		assertThat(driver.getPageSource(), containsString(expected));
	}

}
