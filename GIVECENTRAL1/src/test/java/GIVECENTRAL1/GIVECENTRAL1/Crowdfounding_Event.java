package GIVECENTRAL1.GIVECENTRAL1;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
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
@Listeners(com.utility.Listenerclass.class)
public class Crowdfounding_Event extends BaseClass {
//	WebDriver driver;
	@Test
	public void CrowdfoundingEvent() throws InterruptedException {
		Setup();
		test = extent.createTest("Crowdfounding_Event");
//		ChromeOptions op = new ChromeOptions();
//        op.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(op);
//        driver.manage().window().maximize();
        driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Login...
        //user name
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
        //click on event
        Thread.sleep(10000);
        WebDriverWait eventwait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement event = eventwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Events']")));
        event.click();
        //click on add new
        Thread.sleep(6000);
        WebDriverWait addnewwait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addnew = addnewwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Add New']")));
        addnew.click();
        //event name
        String randomStr = usingRandomUUID();
        WebElement eventname = driver.findElement(By.cssSelector("#event_title"));
        eventname.sendKeys(randomStr);
        //event type 
        WebElement eventtype = driver.findElement(By.cssSelector("#event_type"));
        Select type = new Select(eventtype);
        type.selectByVisibleText("Crowdfunding");
        //goal ammount
        WebElement goalammount = driver.findElement(By.cssSelector("#target_amount"));
        goalammount.sendKeys("100");
        //javascript obj
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // click on next 
        WebElement next = driver.findElement(By.cssSelector("#nexttab"));
        js.executeScript("arguments[0].scrollIntoView();", next);
        next.click();
        //account
        WebElement account = driver.findElement(By.cssSelector("#cc_accounts_merchant_id_id"));
        Select acc = new Select(account);
        acc.selectByVisibleText("GiveCentral Vantiv");
        //another account
        WebElement otheracc = driver.findElement(By.cssSelector("#ec_accounts_merchant_id_id"));
        Select acc1 = new Select(otheracc);
        acc1.selectByVisibleText("GiveCentral Vantiv");
         //next
         WebElement nexttab = driver.findElement(By.cssSelector("#nexttab1"));
         js.executeScript("arguments[0].scrollIntoView();", nexttab);
         nexttab.click();
         //click on next
         WebElement nexttab2 = driver.findElement(By.cssSelector("#nexttab2"));
        nexttab2.click();
        //click on next
        WebElement nexttab5 = driver.findElement(By.cssSelector("#nexttab5"));
        nexttab5.click();
        //click on next
        WebElement nexttab6 = driver.findElement(By.cssSelector("#nexttab6"));
        nexttab6.click();
        //click on next
        WebElement nexttab7 = driver.findElement(By.cssSelector("#nexttab7"));
        nexttab7.click();
        //click on submit
        WebElement submit = driver.findElement(By.cssSelector("button[class='btn btn-primary btn-shd addEvent freqType']"));
        submit.click();
        //driver close
        Thread.sleep(10000);
//        driver.close();
    }
    static String usingRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
    }
//    @AfterMethod
//    public void cb() {
//    	driver.close();
//    }
	
}
