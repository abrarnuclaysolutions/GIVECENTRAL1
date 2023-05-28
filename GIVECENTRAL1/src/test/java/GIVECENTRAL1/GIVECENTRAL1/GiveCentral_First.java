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

public class GiveCentral_First {
	@Test
	public void GC_First() throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
        op.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(op);

        driver.manage().window().maximize();
        //Website URL with Location
        driver.get("https://www.givecentral.org/location/7/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
      
        //Select Event
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("img[title='new image event']")).click();
        //Add amount
        driver.findElement(By.cssSelector("#amount")).sendKeys("0.01");
        // Frequency 
        WebElement element = driver.findElement(By.cssSelector("#frequency"));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Monthly");
        // Submit Value
        driver.findElement(By.cssSelector("#submitBtn")).click();     
        
        // Checkout button with Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        WebElement element2 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkoutBtn")));
        element2.click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".btn.btn-primary.float-right.btn-sm.btn-mob")).click();
//        //click on sign up
//        WebElement signup = driver.findElement(By.xpath("//a[contains(text(),'Complete Profile')]"));
//        signup.click();
//        //fill form
//        //fname
//        Thread.sleep(2000);
//        WebElement fname = driver.findElement(By.xpath("//input[@id='ufname']"));
//        js.executeScript("arguments[0].scrollIntoView();", fname);
//        fname.sendKeys("kaif");
//        //lname
//        driver.findElement(By.xpath("//input[@id='ulname']")).sendKeys("aslam");
//        //user name
//        driver.findElement(By.xpath("//input[@id='uid']")).sendKeys("kaifaslam");
//        //email
//        driver.findElement(By.xpath("//input[@id='uemail']")).sendKeys("kaifaslam@gmail.com");
//        //pass1
//        driver.findElement(By.xpath("//input[@id='upassword']")).sendKeys("kaifaslam12345");
//        //Cpass2
//        driver.findElement(By.xpath("//input[@id='conf_upassword']")).sendKeys("kaifaslam12345");
//        //address
//        driver.findElement(By.xpath("//input[@id='daddress1']")).sendKeys("sansarpur");
//        //city
//        driver.findElement(By.xpath("//input[@id='ddonor_city']")).sendKeys("saharanpur");
//        //state
//        WebElement state = driver.findElement(By.xpath("//select[@name='ddonor_state']"));
//        Select st = new Select(state);
//        st.selectByVisibleText("California ");
//        //enter zip
//        driver.findElement(By.xpath("//input[@id='dzip']")).sendKeys("12121");
//        //card number 
//        WebElement cn = driver.findElement(By.xpath("//input[@id='cardNo']"));
//        js.executeScript("arguments[0].scrollIntoView();", cn);
//        cn.sendKeys("4242424242424242");
//        //month
//        WebElement month = driver.findElement(By.xpath("//select[@id='sel_month']"));
//        Select mon = new Select(month);
//        mon.selectByVisibleText("02");
//        //year
//        WebElement year = driver.findElement(By.xpath("//select[@id='sel_year']"));
//        Select ye = new Select(year);
//        ye.selectByVisibleText("2025");
//        //enter cvv
//        driver.findElement(By.xpath("//input[@id='cvvNo']")).sendKeys("121");
//        //zip again
//        driver.findElement(By.xpath("//input[@id='uzip']")).sendKeys("12121");
//        //click on check box
//        driver.findElement(By.xpath("//label[@class='field option block']//span[@class='checkbox']")).click();
//        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
//        //submit form
//        driver.findElement(By.xpath("//button[@id='register']")).submit();
        
        //Login 
        driver.findElement(By.cssSelector("#username")).sendKeys("kaif12345");
        driver.findElement(By.cssSelector("#password")).sendKeys("kaif12345");
        driver.findElement(By.cssSelector("#logCnf")).click();
        
        //submit after login
        driver.findElement(By.cssSelector("#submit_gift")).click(); 
//        close driver
        Thread.sleep(10000);
        driver.close();
	}
}
