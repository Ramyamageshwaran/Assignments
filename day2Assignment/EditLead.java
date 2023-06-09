package week2.day2Assignment;

import org.openqa.selenium.By;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethod{
	
	
	@Test(dataProvider = "testData")
	public  void runEditLead(String pnum) throws InterruptedException {
		
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Google");
		driver.findElement(By.name("submitButton")).click();
	}
	@DataProvider
	public String[][] testData() {
	     String[][] data= new String [1][1];
	     data[0][0]="9677";
	     return data;
	
	}
}