package week2.day2Assignment;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class CreateLead extends ProjectSpecificMethod{
	@BeforeTest
	public void setData() {
		fileName="SalesforceDetails";
	}
@Test(dataProvider = "testData")
	public  void runCreateLead(String cname,String fname,String lname,String pnum) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pnum);
		driver.findElement(By.name("submitButton")).click();
		
}
}
