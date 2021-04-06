package cr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Analyticreport {

	public static void main(String[] args) throws Exception  {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://analytics.google.com/analytics/web/?authuser=0#/report/content-site-search-search-terms/a37442234w65811777p67654637/_u.date00=20130420&_u.date01=20200426&explorer-table.plotKeys=%5B%5D&explorer-table.rowStart=495000&explorer-table.rowCount=5000/");

		driver.manage().window().maximize();

		driver.findElement(By.id("identifierId")).sendKeys("gaurav.mishra@rekhta.org");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement Next = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
		Next.click();
		driver.findElement(By.name("password")).sendKeys("9599587719");//*
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Nxt = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span"));
		Nxt.click();

		Thread.sleep(15000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.switchTo().frame("galaxyIframe");
		next(driver,0);
		
		for (int i = 0; i <51; i++) {
			next(driver,i+1);
		}
	}

	public static void next(WebDriver driver, int i) throws Exception {
		Thread.sleep(40000);
		
		
		//driver.switchTo().defaultContent();
		WebElement Export = driver.findElement (By.xpath("//span[text()='Export']"));    //(By.cssSelector("[data-guidedhelpid=\"toolbar-export\"]")) ;                           //(By.xpath("//span[. = 'Export']"));
				
		
		Export.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Excel = driver
				.findElement(By.xpath("//*[@id=\"ID-reportHeader-reportToolbar-exportControl\"]/div/ul/li[3]"));
		Excel.click();
	Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Page = driver
				.findElement(By.xpath("//*[@id=\"ID-explorer-table\"]/div[3]/div[1]/div/span[3]/ul/li[2]"));
		Page.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		WebElement scroll = driver.findElement(By.cssSelector("body"));
		scroll.sendKeys(Keys.HOME);
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}

}

