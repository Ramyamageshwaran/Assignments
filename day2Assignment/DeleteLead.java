package week2.day2Assignment;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
	
 	public class DeleteLead extends ProjectSpecificMethod {
 		
 		
 		@Test(dataProvider = "testData")
 		
		public  void runDeleteLead(String pnum) throws InterruptedException {

			//Find Leads
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			//Click on Phone
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			//Enter Country code in phone number
			driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();		
			//Enter phone number
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);
			//Click Leads
			driver.findElement(By.xpath("//button[@class='x-btn-text'][text()='Find Leads']")).click();
			Thread.sleep(3000);
			//Capture lead ID of First Resulting lead
			driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner')]//child::a")).click();
			//Click Delete
			driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous'][text()='Delete']")).click();
			//Click Find leads
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			
 }
 		@DataProvider
 		public String[][] testData() {
 		     String[][] data= new String [1][1];
 		    
 		     data[0][0]="9677";
 		     return data;
			
		}

 	}
	