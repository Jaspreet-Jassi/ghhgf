package selenium_demo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Switchtabs_demo
{
	public static void main(String[] arg)
	{
	String path;
	path=System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	WebDriver dr= new ChromeDriver();
	dr.get("https://in.linkedin.com/");
	
	JavascriptExecutor js= (JavascriptExecutor) dr;
	js.executeScript("window.open()");
	
	ArrayList<String> al= new ArrayList<>(dr.getWindowHandles());
	
	dr.switchTo().window(al.get(1));
	dr.get("https://www.facebook.com/");
	
//	dr.findElement(By.id("email")).sendKeys("admin");
//	dr.findElement(By.id("pass")).sendKeys("admin");
//	dr.findElement(By.xpath("//input[contains(@id,'u_0')]")).click();
//	dr.navigate().back();
	
	Select day= new Select(dr.findElement(By.id("day")));
	day.selectByValue("15");
	
	Select mn= new Select(dr.findElement(By.id("month")));
	mn.selectByVisibleText("Jun");

	dr.findElement(By.id("year")).sendKeys("1990");
	
	ArrayList<WebElement> s=new ArrayList<>(dr.findElements(By.xpath("//span[@class='_5k_2 _5dba']")));
	
	System.out.println(s.size());
		
	for (int i=0;i<s.size();i++)
	{
		System.out.println(s.get(i).getText());
	}
	if (s.get(0).getText().equals("Female"))
	{
	s.get(1).click();
	}
	
	dr.switchTo().window(al.get(0));
	dr.findElement(By.xpath("//input[@name='keywords']")).sendKeys("automation");
	}
	
}
