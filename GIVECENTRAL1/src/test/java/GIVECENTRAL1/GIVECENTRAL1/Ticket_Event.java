package GIVECENTRAL1.GIVECENTRAL1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ticket_Event {
	@Test
	public void TicketEvent() throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.givecentral.org/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Login...
		// user name
		WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement elementofusername = waitofusername
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		elementofusername.sendKeys("abrark_gc");

		// password
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys("tiger@123456789");

		// login button
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();
		// click on event
		Thread.sleep(10000);
		WebDriverWait eventwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement event = eventwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Events']")));
		event.click();
		// click on add new
		Thread.sleep(5000);
		WebDriverWait addnewwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addnew = addnewwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Add New']")));
		addnew.click();
		// event name
		String randomStr = usingRandomUUID();
		WebElement eventname = driver.findElement(By.cssSelector("#event_title"));
		eventname.sendKeys(randomStr);
		// event type
		WebElement eventtype = driver.findElement(By.cssSelector("#event_type"));
		Select type = new Select(eventtype);
		type.selectByVisibleText("Ticket Events");
		// javascript obj
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// click on next
		WebElement next = driver.findElement(By.cssSelector("#nexttab"));
		js.executeScript("arguments[0].scrollIntoView();", next);
		next.click();
		// account
		Thread.sleep(3000);
		WebElement account = driver.findElement(By.cssSelector("#cc_accounts_merchant_id_id"));
		Select acc = new Select(account);
		acc.selectByVisibleText("GiveCentral Vantiv");
		// another account
		WebElement otheracc = driver.findElement(By.cssSelector("#ec_accounts_merchant_id_id"));
		Select acc1 = new Select(otheracc);
		acc1.selectByVisibleText("GiveCentral Vantiv");
		// next
		WebElement nexttab = driver.findElement(By.cssSelector("#nexttab1"));
		js.executeScript("arguments[0].scrollIntoView();", nexttab);
		nexttab.click();
		// click on next
		WebElement nextagain = driver.findElement(By.cssSelector("#nexttab2"));
		nextagain.click();
		// price per unit
		WebElement priceunit = driver.findElement(By.cssSelector("#ticket_amount"));
		priceunit.sendKeys("5");
		// number of units
		WebElement numberunits = driver.findElement(By.cssSelector("#ticket_no"));
		numberunits.sendKeys("10");
		// click on next
		WebElement next4 = driver.findElement(By.cssSelector("#nexttab4"));
		next4.click();
		// click on next
		WebElement next6 = driver.findElement(By.cssSelector("#nexttab6"));
		next6.click();
		// click on next
		WebElement next7 = driver.findElement(By.cssSelector("#nexttab7"));
		next7.click();
		// click on submit
		Thread.sleep(5000);
		WebElement submit = driver
				.findElement(By.xpath("//button[@class='btn btn-primary btn-shd addEvent freqType']"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
//		close driver
		Thread.sleep(10000);
		driver.close();
	}

	static String usingRandomUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().replaceAll("_", "");
	}
}
