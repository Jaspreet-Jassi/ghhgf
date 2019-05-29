package zoopla_task;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoopla
{
	public void task()
	{
		System.setProperty("webdriver.chrome.driver", "D://jassi//selenium_jassi//chromedriver//chromedriver.exe");
		WebDriver dr= new ChromeDriver();
		dr.get("https://www.zoopla.co.uk/");
		
		dr.findElement(By.id("search-input-location")).sendKeys("london");
		dr.findElement(By.id("search-submit")).click();
		
		ArrayList<WebElement> al= new ArrayList<>(dr.findElements(By.className("text-price")));
		System.out.println("no.of elements"+al.size());
	
		String[] b= new String[al.size()];
		
		for (int i=0;i<al.size();i++)
		{
			b[i]=al.get(i).getText();
			b[i]=b[i].replaceAll(" ", "");
			b[i]=b[i].replaceAll("[a-zA-Z,£]", "");
			System.out.println(b[i]);
		}

		for (int i=0;i<b.length;i++)
			{
			for (int j=0;j<b.length-1;j++)
			{
				if (Integer.parseInt(b[j])>Integer.parseInt(b[j+1]))
				{
					int temp=Integer.parseInt(b[j]);
					b[j]=b[j+1];
					b[j+1]=Integer.toString(temp);
				}
			}
			}

		System.out.println("\nNo.s after sorting");
		for (int i=0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
		dr.close();
	}
	
public static void main(String... arg)
{
	Zoopla obj= new Zoopla();
	obj.task();
	
	}
}
