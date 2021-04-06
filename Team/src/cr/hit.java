package cr;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hit {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rekhta.org/careerdetails/1/dotnet");

		driver.manage().window().maximize();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		WebElement apl= driver.findElement(By.id("aplyOpening"));
		apl.click();

	}

}
