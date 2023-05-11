package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollCode {
	static WebDriver d;

	public static void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public static void scrollToUp() {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,-350)", "");
	}

	public static void dynamicScroll(String pixel) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0," + pixel + ")", "");
	}

	// scroll till bottom of the page
	public static void bottomMostScroll() {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// scroll to top of the page
	public static void topMostScroll() {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollTo(0,0)");
	}

}
