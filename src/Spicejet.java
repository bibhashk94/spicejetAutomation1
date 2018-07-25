  import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Spicejet
{
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
			driver.get("http://www.spicejet.com/?utm_source=Brand%20Campaign%20_&utm_medium=cpc_google&utm_term=O%26D&utm_campaign=Spicejet%20all%20route%20campaign&gclid=EAIaIQobChMIk5_Dqemq3AIVhSQrCh2l2gI-EAAYASAAEgIqTPD_BwE");
			// to select drop down arrow  column
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
			 // to select the complete table of city
			 WebElement wb =  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTNR"));
			 //tag name of chennai
			 List<WebElement> list = wb.findElements(By.tagName("a"));
			 
			 for(WebElement e :list)
			 {
				 String text = e.getText();
				 if(text.contains("Chennai (MAA)"))
				 {
					 System.out.println(text);
					 e.click();
					 break;
				 }
			 }
			 Thread.sleep(5000);
			  // to select to column
			 //driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
			 WebElement wb1 = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTNR"));
			 List<WebElement> list1 = wb1.findElements(By.tagName("a"));
			 
			 for(WebElement e1 :list1)
			 {
				 String text1 = e1.getText();
				 System.out.println(text1);
				 if(text1.contains("Goa (GOI)"))
				 {
					 System.out.println(text1);
					 e1.click();
					 break;
				 }
			 }
			 
			 
			 boolean flag = false;
			 
			 driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();
			  
			 while(true)
			 {
				 driver.findElement(By.xpath("//span[text()='Next']")).click();
				 
				 //to select both month and year row
				 
				 String month = driver.findElement(By.xpath("//div[@class ='ui-datepicker-title'][1]/span")).getText();
				 if(month.contains("October"))
				 {
					 
					 //to select complete table
					WebElement table = driver.findElement(By.xpath(".//*[@id = 'ui-datepicker-div']/div[1]/table"));
					List<WebElement> rows = table.findElements(By.tagName("tr"));
					for(WebElement r:rows)
					{
						List<WebElement> columns = r.findElements(By.tagName("td"));
						for(WebElement c:columns)
						{
							String text =c.getText();
							System.out.println(text);
							
							if(text.contains("19"))
							{
								c.click();
								flag= true;
								break;
								
							}
						}
						if(flag==true)
						{
							break;
						}
					}
				 }
				 
				 boolean flag1 = false;
				 
				 driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).click();
				  
				 while(true)
				 {
					 driver.findElement(By.xpath("//span[text()='Next']")).click();
					 
					 //to select both month and year row
					 
					 String month1 = driver.findElement(By.xpath("//div[@class ='ui-datepicker-title'][1]/span")).getText();
					 if(month1.contains("October"))
					 {
						 
						 //to select complete table
						WebElement table = driver.findElement(By.xpath(".//*[@id = 'ui-datepicker-div']/div[1]/table"));
						List<WebElement> rows = table.findElements(By.tagName("tr"));
						for(WebElement r:rows)
						{
							List<WebElement> columns = r.findElements(By.tagName("td"));
							for(WebElement c:columns)
							{
								String text =c.getText();
								System.out.println(text);
								
								if(text.contains("19"))
								{
									c.click();
									flag1= true;
									break;
									
								}
							}
							if(flag1==true)
							{
								break;
							}
						}
						 
						 driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
						 
					 }
					 
					

				 
				 
				 
			 }
				 
			 
			 
			 
			 
		}
		}
}

			
			