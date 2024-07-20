package pruebas;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Tools.EnumBrowser;
import Tools.SeleniumTools;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;


	//-----------------------------------------------------CODIGO BASE-------------------------------------- 
	//-----------------------------------------------------INICIA CLASE PARAMETRIZADA-------------------------------------- 
@RunWith(Parameterized.class)
public class search {
	@Parameter
	public static String browser;
	public static WebDriver driver = null;
	//-----------------------------------------------------SE DEFINEN LOS BROWSERS COMO PARAMETROS-------------------------------------- 	
	@Parameters
	public static Object[] getBrowser(){
		return new Object[]{ 
				EnumBrowser.CHROME.toString(), 
				EnumBrowser.FIREFOX.toString(),
		};
	}
	//-----------------------------------------------------DEFINICION DE LOS NAVEGADORES A UTILIZAR-------------------------------------- 
	@Before
	public void setUpDriver() {
		if(browser.equals(EnumBrowser.CHROME.toString())) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browser.equals(EnumBrowser.FIREFOX.toString())) {
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe"); 
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}
	
	//-----------------------------------------------------CODIGO A AUTOMATIZAR-------------------------------------- 
	@Test
	public void Search() {
		try {
		    SeleniumTools.get("https://www.demoblaze.com/",driver);
		    Thread.sleep(2000);
		    SeleniumTools.findElementByXpath("(.//*[normalize-space(text()) and normalize-space(.)='PRODUCT STORE'])[1]/following::a[1]",driver).click();
		    Thread.sleep(2000);
		    SeleniumTools.findElementByXpath("//div[@id='tbodyid']/div/div/a/img",driver).click();
		    Thread.sleep(2000);
		    SeleniumTools.findElementByXpath("//div[@id='tbodyid']/div[2]/div/a",driver).click();
		    Thread.sleep(2000);
		    Alert alert = driver.switchTo().alert();
		    System.out.println("Texto del mensaje emergente: " + alert.getText()); //IMPRIME MENSAJES ESPERADOS COMO VALIDACION
		    alert.accept();
		    Thread.sleep(2000);
		    SeleniumTools.findElementByXpath("(.//*[normalize-space(text()) and normalize-space(.)='PRODUCT STORE'])[1]/following::a[1]",driver).click();
		    Thread.sleep(2000);
		    SeleniumTools.findElementByXpath("//a[contains(text(),'Iphone 6 32gb')]",driver).click();
		    Thread.sleep(2000);
		    SeleniumTools.findElementByXpath("//div[@id='tbodyid']/div[2]/div/a",driver).click();
		    Thread.sleep(2000);
		    Alert alert1 = driver.switchTo().alert();
		    System.out.println("Texto del mensaje emergente 2: " + alert1.getText()); //IMPRIME MENSAJES ESPERADOS COMO VALIDACION
		    alert1.accept();
		    Thread.sleep(2000);
		    SeleniumTools.findElementById("cartur",driver).click();
		    Thread.sleep(3000);
		    SeleniumTools.findElementByXpath("//div[@id='page-wrapper']/div/div[2]/button",driver).click();
		    //LLENADO DEL FORMULARIO
		    Thread.sleep(3000);
		    SeleniumTools.findElementById("name",driver).clear();
			SeleniumTools.findElementById("name",driver).sendKeys("Mauricio");
		    SeleniumTools.findElementById("country",driver).clear();
		    SeleniumTools.findElementById("country",driver).sendKeys("El Salvador");
		    SeleniumTools.findElementById("city",driver).clear();
		    SeleniumTools.findElementById("city",driver).sendKeys("San Salvador");
		    SeleniumTools.findElementById("card",driver).clear();
		    SeleniumTools.findElementById("card",driver).sendKeys("2563452578567825");
		    SeleniumTools.findElementById("month",driver).clear();
		    SeleniumTools.findElementById("month",driver).sendKeys("September");
		    SeleniumTools.findElementById("year",driver).clear();
		    SeleniumTools.findElementById("year",driver).sendKeys("2024");
		    SeleniumTools.findElementByXpath("//div[@id='orderModal']/div/div/div[3]/button[2]",driver).click();
		    SeleniumTools.findElementByXpath("(.//*[normalize-space(text()) and normalize-space(.)='PRODUCT STORE'])[2]/following::h2[1]",driver).click();
		    
		 // VALIDACION DEL ELEMENTO THANKS FOR YOU PUCHASE
		    WebElement modalElement = SeleniumTools.findElementByXpath("//div[10]/h2",driver);
		    String message = modalElement.getText();
            System.out.println("Mensaje de compra exitosa: " + modalElement.getText()); //IMPRIME MENSAJES ESPERADOS COMO VALIDACION

            // VERIFICA SI SE ENCUENTRA EL MENSAJE ESPERADO
            try {
                assertEquals("Thank you for your purchase!", message);
            } catch (AssertionError e) {
                System.out.println("La respuesta no fue la esperada. Mensaje recibido: " + message);
                throw e; // Vuelve a lanzar la excepción para que la prueba falle
            }
		  
		//-----------------------------------------------------CIERRE DE CODIGO A AUTOMATIZAR--------------------------------------   
		    
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
		
	}
	
	@After
	public void tearDown() {
		SeleniumTools.closeDriver(driver); //CIERRA NAVEGADOR
		
	}
}
