package selenium_demo;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser_Demo
{
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D://jassi//selenium_jassi//chromedriver//chromedriver.exe");
		WebDriver d= new ChromeDriver();
		d.get("https://in.linkedin.com/");
			
		ArrayList<WebElement> al= new ArrayList<>(d.findElements(By.tagName("li")));
		System.out.println(al.size());
		for (int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).getText());
		}
		
		ArrayList<WebElement> al1= new ArrayList<>(d.findElements(By.tagName("img")));
		System.out.println(al1.size());
		for (int i=0;i<al1.size();i++)
		{
			System.out.println(al1.get(i).getAttribute("src"));
		}
		
	}

public static void main (String... arg)
{
	OpenBrowser_Demo obj= new OpenBrowser_Demo();
			obj.launch();
}
}

