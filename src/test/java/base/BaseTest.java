package base;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static WebDriver driver;
	public static Properties p = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	@BeforeMethod
	public void startBrowser() throws Exception {

		// System.out.println(System.getProperty("user.dir"));
		fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
		p.load(fr);
		fr1 = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/locators.properties");
		loc.load(fr1);

		System.out.println("file loaded in the system");

		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(op);
			driver.get(p.getProperty("testurl"));

		} else if (p.getProperty("browser").equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			driver.get(p.getProperty("testurl"));
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
		System.out.println("driver close succesful");
	}
}
