package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class FirstTestFW extends BaseTest {

	@Test(dataProvider = "testdata")	
	public static void loginTest(String username, String password) throws InterruptedException {

		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("next_button"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		Thread.sleep(4000);

	}
	@DataProvider(name="testdata")
	public Object [][] tdata(){
		return new Object[][] {
			{"mansi.sahu@3pillarglobal.com","Mansi1511@"},
			{"mansi.sahu23@3pillarglobal.com","Mansi1511@"},
			{"mansi.sahu@3pillarglobal.com","Mansi511@"},
			{"mansi4.sahu@3pillarglobal.com","Mansi15115@"},
		};
		
	}
}
