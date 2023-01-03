package org.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static void LaunchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
	public static void WinMax() {
		driver.manage().window().maximize();
	}
	public static void LoadUrl(String url) {
		driver.get(url);
    	}
	public static void PrintTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void fill(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	public static void btnClick(WebElement ele) {
		ele.click();
	}
	public static void PrintText(WebElement ele) {
		ele.getText();
	}
	public static void quit() {
		driver.quit();
	}
	public static void Close() {
		driver.close();
	}
	public static void Thread() throws InterruptedException {
		Thread.sleep(4000);
	}
	public static void ImplicityWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void ExplicitWait() {
		WebDriverWait w = new WebDriverWait(driver, 10);
	}
	public static void movetoElement(WebElement b) {
		Actions a =new Actions(driver);
		a.moveToElement(b).perform();
	}
	public static void dragAndDrop(WebElement src , WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
	public static void keyUp(CharSequence key) {
		Actions a = new Actions(driver);
		a.keyUp(key).perform();
	}
	public static void keyDown(CharSequence key) {
		Actions a = new Actions(driver);
		a.keyDown(key).perform();
	}
	public static void doubleClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}
	public static void contextClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}
	public static void keyPress(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);
	}
	public static void keyRelease(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(keycode);
	}
	public static void accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public static void dismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	public static File ScreenShot() {
		TakesScreenshot tk =(TakesScreenshot)driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
		return file;
	}
	public static File CreateNewFile() {
		File f = new File("Location");
		return f;
	}
	public static void CopyPaste(String srclocation,String declocation) throws IOException {
		File src = new File(srclocation);
		File dec = new File(declocation);
		FileUtils.copyFile(src, dec);
	}
	public static void JSExecutorMethod() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("javascript command code", "WebElementRef");
	}
	public static void InsertValue(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].setAttribute('value','text')", ele);
	}

}
