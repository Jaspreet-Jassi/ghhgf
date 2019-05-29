package TestNG;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG_demo
{
	WebDriver dr;
@BeforeTest
	public void launch()
	{
		String path=System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver dr= new ChromeDriver();
		dr.get("https://www.facebook.com/");
		//dr.manage().window().maximize();
	}

@Test	
	public void test()
	{
		//String oldtab= dr.getWindowHandle();
		
		dr.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		
		ArrayList<String> newtab= new ArrayList<> (dr.getWindowHandles());
		
		System.out.println(newtab.size());
		
		dr.switchTo().window(newtab.get(0));
		
		dr.get("https://in.linkedin.com/");
	}

@AfterTest
	public void closeb()
	{
		dr.close();
	}
}

