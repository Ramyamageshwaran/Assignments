package marathon3;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceEdge extends SalesForceBase{

	
		@BeforeTest	
		public void setData() {
			fileName="EdgeDetails";
		}
		
	    @Test(dataProvider="testData")
		public void createTestcase(String fname,String amt,String newdate) throws IOException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		Actions mouseact=new Actions(driver);
		mouseact.moveToElement(sales).perform();
		mouseact.click().perform();
		
		//driver.findElement(By.xpath("//a[contains(@class,'filterIcon slds-butto')]")).click();
		WebElement keyDeals = driver.findElement(By.xpath("//a[@class='viewAllLink' and  @aria-label='View All Key Deals']"));
		Actions builder=new Actions(driver);
		builder.scrollToElement(keyDeals).perform();
		driver.executeScript("arguments[0].click();",keyDeals);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input' and @name='Name']")).sendKeys(fname);
		driver.findElement(By.xpath("(//span[text()='--None--'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		driver.findElement(By.xpath("(//span[text()='--None--'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input' and @type='text']")).sendKeys(amt);
		driver.findElement(By.xpath("//input[@class='slds-input' and @name='CloseDate']")).sendKeys(newdate);
		driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
		
		WebElement findElement = driver.findElement(By.xpath("(//span[text()='Needs Analysis'])[2]"));
		driver.executeScript("arguments[0].click();",findElement);
		driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]")).click();
		List<WebElement> searchList= driver.findElements(By.xpath("//li[@class='slds-listbox__item']"));
		searchList.get(1).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("snap/verifyMsg.png");
		FileUtils.copyFile(source,destination);
			
	}

}
