package marathon3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForcePro extends SalesForceBase{
	@BeforeTest	
	public void setData() {
		fileName="SalesforceQA";
	}
	
   @Test(dataProvider="testData")
	public void createTestcase(String ques,String details) throws IOException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		WebElement logo = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();",logo);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys(ques);
		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(details);
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("snap/verifyMsg1.png");
		FileUtils.copyFile(screenshot,destination);
		
	}

}
