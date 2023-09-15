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
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.ITestResult;
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
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.utility.Listenerclass.class)
public class AddNewEvent extends BaseClass {
	@Test
	public void Add_New_Event() throws InterruptedException {
		abcdemo ab = new abcdemo();
		String password = ab.pass;
		String username = ab.username;
        driver.get("https://www.givecentral.org/admin/donor-details/profile/kaif12345");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Login...
        driver.findElement(By.cssSelector("#username")).sendKeys(username);// username
        driver.findElement(By.cssSelector("#password")).sendKeys(password);// password
        driver.findElement(By.cssSelector("#logCnf")).click();// login button
        //URL of profile
        driver.get("https://www.givecentral.org/admin/donor-details/profile/kaif12345");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Click on add new event
        Thread.sleep(7000);
        WebElement addnewevent = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(9) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2) > button:nth-child(1)"));
        js.executeScript("arguments[0].scrollIntoView();", addnewevent);
        addnewevent.click();
        //Select an event
        WebElement selectevent = driver.findElement(By.cssSelector("#event"));
        selectevent.click();
        Select dropSelect = new Select(selectevent);
        dropSelect.selectByVisibleText("20-March");
        //add Frequency
        WebDriverWait waitoffrequency = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addfrequency = waitoffrequency.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#paymentFrequency")));
        addfrequency.click();
        Select weeklyselect = new Select(addfrequency);
        weeklyselect.selectByVisibleText("Weekly");
        //add amount
        driver.findElement(By.cssSelector("#amount")).sendKeys("0.05");
        //paymentstartdate
        WebElement selectdate = driver.findElement(By.cssSelector("#paymentStartDate"));
        selectdate.click();
        Thread.sleep(5000);
        WebElement dayselect = driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today' or @class=' ui-datepicker-week-end  ui-datepicker-today' or @class='  ui-datepicker-today' or @class=' ui-datepicker-days-cell-over  ui-datepicker-today' or @class=' ui-datepicker-week-end ui-datepicker-days-cell-over  ui-datepicker-today']"));
        dayselect.click();//currant date issue
        Actions std = new Actions(driver);
        //Add payment method
        WebElement clickpaymethod = driver.findElement(By.cssSelector("#paymentMethod"));
        Select addpaymethod = new Select(clickpaymethod);
        addpaymethod.selectByVisibleText("Visa - xxx4242 added on 2023-03-02 expiring on 2033-09-30");
        //add source code
        WebElement sourcecode = driver.findElement(By.cssSelector(".caret"));
        js.executeScript("arguments[0].scrollIntoView();", sourcecode);
        sourcecode.click();
        WebElement clickonsourcecode = driver.findElement(By.xpath("//a[normalize-space()='110022 -']"));
        js.executeScript("arguments[0].scrollIntoView();", clickonsourcecode);
        clickonsourcecode.click();
        //click on submit
        WebElement submitelement = driver.findElement(By.xpath("//input[@id='submit']"));
        js.executeScript("arguments[0].scrollIntoView();", submitelement);
        submitelement.click();
        //click on popup
        WebElement popup = driver.findElement(By.cssSelector("div[id='systemMessagesDiv'] button[type='button']"));
        popup.click();     
	}
}
