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
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Process_One_time_Payment {
	@Test
	public void ProcessOneTimePayment() throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
        op.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(op);
        driver.manage().window().maximize();
        driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Login...
        driver.findElement(By.cssSelector("#username")).sendKeys("abrark_gc");// username
        driver.findElement(By.cssSelector("#password")).sendKeys("tiger@123456789");// password
        WebDriverWait waitoflogin = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement clicklogin = waitoflogin.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
        clicklogin.click();
        // driver.findElement(By.cssSelector("#logCnf")).click();// login button
        //click on payment
        Thread.sleep(10000);
        WebDriverWait paymentwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickpayment = paymentwait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//span[normalize-space()='Payments']")));
        clickpayment.click();
        //click on process one time payment
        Thread.sleep(5000);
        WebElement potp = driver.findElement(By.xpath("//span[normalize-space()='Process One-Time Payments']"));
        potp.click();
        //enter text on profile id
        
        WebElement profileelement = driver.findElement(By.cssSelector("#useridTmp"));
        profileelement.sendKeys("kaif12345");
        Thread.sleep(4000);
        WebElement sop = driver.findElement(By.xpath("//ul[@id='ui-id-2']//li[@class='ui-menu-item']//a[@class='ui-menu-item-wrapper' and contains(text(),'Kaif Khan')]"));
        Actions act = new Actions(driver);
        act.moveToElement(sop).sendKeys(Keys.ENTER);
        
        
//        close driver
        Thread.sleep(5000);
        driver.close();

    }
    public static void hover(WebDriver driver , WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }
}
