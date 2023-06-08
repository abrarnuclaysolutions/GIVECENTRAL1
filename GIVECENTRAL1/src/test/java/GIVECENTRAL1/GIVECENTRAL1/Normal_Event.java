package GIVECENTRAL1.GIVECENTRAL1;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
@Listeners(com.utility.Listenerclass.class)
public class Normal_Event extends BaseClass {
	@Test
	public void NormalEvent() throws InterruptedException {
		//URL
		driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Login...
        WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementofusername = waitofusername
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        elementofusername.sendKeys("abrark_gc");
        // driver.findElement(By.cssSelector("#username")).sendKeys("abrark_gc");//
        // username
        WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementofpass = waitofpass
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        elementofpass.sendKeys("tiger@123456789");
        // driver.findElement(By.cssSelector("#password")).sendKeys("tiger@12345678");//
        // password
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
        Thread.sleep(5000);
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
        type.selectByVisibleText("Normal Events");
        //javascript obj
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        // click on next 
        WebElement next = driver.findElement(By.cssSelector("#nexttab"));
        js.executeScript("arguments[0].scrollIntoView();", next);
        next.click();
        //account
        Thread.sleep(3000);
        WebElement account = driver.findElement(By.cssSelector("#cc_accounts_merchant_id_id"));
        Select acc = new Select(account);
        acc.selectByVisibleText("GiveCentral Vantiv");
        //another account
        WebElement otheracc = driver.findElement(By.cssSelector("#ec_accounts_merchant_id_id"));
        Select acc1 = new Select(otheracc);
        acc1.selectByVisibleText("GiveCentral Vantiv");
        //amount
        WebElement amount = driver.findElement(By.cssSelector("#percent_tax_deduction"));
        js.executeScript("arguments[0].scrollIntoView();", amount);
        amount.sendKeys("100");
        //next
        WebElement nexttab = driver.findElement(By.cssSelector("#nexttab1"));
        js.executeScript("arguments[0].scrollIntoView();", nexttab);
        nexttab.click();
        //click on next 
        WebElement nextagain = driver.findElement(By.cssSelector("#nexttab2"));
        nextagain.click();
        // click on next
        WebElement next3 = driver.findElement(By.cssSelector("#nexttab3"));
        js.executeScript("arguments[0].scrollIntoView();", next3);
        next3.click();
        //next5
        WebElement next5 = driver.findElement(By.cssSelector("#nexttab5"));
        next5.click();
        //next6
        WebElement next6 = driver.findElement(By.cssSelector("#nexttab6"));
        next6.click();
        //next7
        WebElement next7 = driver.findElement(By.cssSelector("#nexttab7"));
        next7.click();
        //submit
        WebElement submit = driver.findElement(By.cssSelector("button[class='btn btn-primary btn-shd addEvent freqType']"));
        submit.click();
    }
    static String usingRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
      }
}
