package cr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sourcepage {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.get("https://sufinama.org/");
		//driver.manage().window().maximize();
		Thread.sleep(2000);
		File file = new File("C:\\Users\\Admin\\Desktop\\Copy of cache.xlsx");
		 FileInputStream iFile = new FileInputStream(file);
		 XSSFWorkbook wb = new XSSFWorkbook(iFile);
	     XSSFSheet sheet =  wb.getSheet("URL");
	     int rowCount = sheet.getLastRowNum();
	        System.out.println("the no of rows are : " + rowCount);
	        
	       try{
	        for (int row = 1 ; row < rowCount; row++)
	        {
	        	driver =new ChromeDriver();
	        	String URL1 =sheet.getRow(row).getCell(4).getStringCellValue();
	        	System.out.println("Read XLS");
	        	driver.get(URL1);
	    		Thread.sleep(2000);
	        	System.out.println("Page title is : "+driver.getTitle());
	    		Thread.sleep(2000);
	    	   WebElement desc=driver.findElement(By.xpath("//meta[@name='description']"));
	    	  String desc1=desc.getAttribute("content");
	    	  System.out.println(desc1);
	    	
	    	if(URL1==driver.getCurrentUrl())
	    	{
	    		sheet.getRow(row).getCell(5).setCellValue(desc1);
	    		FileOutputStream fo=new FileOutputStream(file);
	    		wb.write(fo);
	    		System.out.println("added");	
	    	}
	    	
	    	}
	    	driver.close();
	    	
	        
	        
	     	driver.close();
	       }
	       
	       catch(Exception e)
	       {System.out.println(e);}
	        

	}



 



		//System.out.println("Page title is : "+driver.getTitle());
		//Thread.sleep(2000);
	//WebElement desc=driver.findElement(By.xpath("//meta[@name='description']"));
	//System.out.println("Description is:"+desc.getAttribute("content"));
		
		//String str = driver.getPageSource();
		//System.out.println(str);

	}


