package week2.day2Assignment;


	import org.openqa.selenium.By;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	

	public class FindLead extends ProjectSpecificMethod{
	@Test(dataProvider="testData")
		public void testDuplicateLead(String pnum) throws InterruptedException {
			
			
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pnum);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner')]/a")).click();
			driver.findElement(By.linkText("Duplicate Lead")).click();
			driver.findElement(By.name("submitButton")).click();
			//driver.close();
	}
	@DataProvider
	public String[][] testData() {
		String[][] data=new String[1][1];
		data[0][0]="9677040077";
		return data;
	}

	}



