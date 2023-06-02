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
public class Make_Guest_Payment extends BaseClass {
	@Test
	public void MakeGuestPayment() throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
        op.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(op);
        driver.manage().window().maximize();
        driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Login...
        driver.findElement(By.cssSelector("#username")).sendKeys("abrark_gc");// username
        driver.findElement(By.cssSelector("#password")).sendKeys("tiger@123456789");// password
        driver.findElement(By.cssSelector("#logCnf")).click();// login button
        //javascript object
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //click on payment
        Thread.sleep(10000);
        WebDriverWait paymentwait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement clickpayment = paymentwait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//span[normalize-space()='Payments']")));
        clickpayment.click();
        //click on make guest payment
        Thread.sleep(5000);
        WebDriverWait guestpay = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement clickguest = guestpay.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//span[normalize-space()='Make Guest Payment']")));
        clickguest.click();
        //check on click event
        WebElement check = driver.findElement(By.cssSelector("input[value='36715']"));
        js.executeScript("arguments[0].scrollIntoView();", check);
        check.click();
        //add amount 
        WebElement eventpay = driver.findElement(By.cssSelector("input[name='amount[]'][type='text'][onfocus='gcheck(36715)']"));
        eventpay.sendKeys("0.05");
        //scroll and click on continue
        WebDriverWait continuewait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement getcontinue = continuewait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#eventBtn")));
        js.executeScript("arguments[0].scrollIntoView();", getcontinue);
        getcontinue.click();
        //first name
        WebElement firstname = driver.findElement(By.cssSelector("input[name='donor_first_name']"));
        firstname.sendKeys("kaif");
        //last name
        WebElement lastname = driver.findElement(By.cssSelector("input[name='donor_last_name']"));
        lastname.sendKeys("khan");
        //email
        WebElement email = driver.findElement(By.cssSelector("input[placeholder='you@domain.com']"));
        email.sendKeys("abrar@nuclaysolutions.com");
        //address
        WebElement address = driver.findElement(By.cssSelector("input[name='address1']"));
        address.sendKeys("sansarpur(saharanpur)");
        //country
        WebElement country = driver.findElement(By.cssSelector("#country"));
        Select selectcountry = new Select(country);
        selectcountry.selectByVisibleText("United States");
        //state
        WebElement state = driver.findElement(By.cssSelector("#donor_state"));
        Select selectstate = new Select(state);
        selectstate.selectByVisibleText("California  ");
        //city
        WebElement city = driver.findElement(By.cssSelector("input[name='donor_city']"));
        city.sendKeys("saharanpur");
        //zip code
        WebElement zipcode = driver.findElement(By.cssSelector("#zip"));
        zipcode.sendKeys("23445");
        // click on continue
        WebElement continueelement = driver.findElement(By.cssSelector("#profileBtn"));
        continueelement.click(); 

        //name on card
        WebElement namecard = driver.findElement(By.cssSelector("input[name='cc_name_on_card']"));
        namecard.sendKeys("abrarkhan");
        //card number
        WebElement cardnumber = driver.findElement(By.cssSelector("#cc_card_no"));
        cardnumber.sendKeys("42424242424242");
        //select month
        WebElement month = driver.findElement(By.cssSelector("#sel_month"));
        Select selectmonth = new Select(month);
        selectmonth.selectByVisibleText("06");
        //select year
        WebElement year = driver.findElement(By.cssSelector("#sel_year"));
        Select selectyear = new Select(year);
        selectyear.selectByVisibleText("2023");
       
        //Enter cvv 
        WebElement cvv = driver.findElement(By.cssSelector("#cc_cvv"));
        cvv.sendKeys("121");
        //address1
        WebElement clickcheck = driver.findElement(By.cssSelector("#pDemoAdd"));
        clickcheck.click();
        
        //submit
        WebDriverWait submitwait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement submit = submitwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Submit']")));
        js.executeScript("arguments[0].scrollIntoView();", submit);
        submit.click();
        Thread.sleep(6000);
	}
	@AfterMethod
	public void cb() {
		driver.close();
	}
}
