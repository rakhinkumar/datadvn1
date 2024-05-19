package Datadrvn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadrv {
	WebDriver driver;
	@Test(dataProvider="testdata")
	public void DemoProject(String username,String password)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rakhi N Kumar\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
	}
	@DataProvider(name="testdata")
	public Object[] [] testdatafeed()
	{
		ReadExcelFile config=new ReadExcelFile("C:\\Users\\Rakhi N Kumar\\OneDrive\\Desktop\\datadriven.xlsx");
		int rows =config.getRowCount(0);
		Object[][] credntls=new Object[rows][2];//mention only 2 values in excel sheet
		for(int i=0;i<rows;i++)
		{
			credntls[i][0]=config.getData(0,i,0);
			credntls[i][1]=config.getData(0,i,1);
		}
		return credntls;
		}
	}


