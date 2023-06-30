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
import java.util.Random;
//import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Listeners(com.utility.Listenerclass.class)
public class Dynamic_Page1 extends BaseClass {
	@Test
	public void DynamicPage1() throws InterruptedException {
		driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // object of javascript
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // Login...
        // user name
        WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementofusername = waitofusername.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        elementofusername.sendKeys("abrark_gc");

        // password
        WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementofpass = waitofpass.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        elementofpass.sendKeys("loc@lbm@2023!");

        // login button
        WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement clicklogin = waitoflogin.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
        clicklogin.click();
      //remove popup
        Thread.sleep(4000);
        WebElement icon = driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='adminPageModal']/div[1]/div[1]/div[1]/button[1]/span[1]/img[1]"));
        icon.click();
        //click on Dynamic pages
        Thread.sleep(10000);
        WebDriverWait dynamicwait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement clickdynamic = dynamicwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Dynamic Pages']")));
        js.executeScript("arguments[0].scrollIntoView();", clickdynamic);
        clickdynamic.click();
        //click on personalized giving pages
        Thread.sleep(5000);
        WebDriverWait personalwait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement personalclick = personalwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Personalized Giving Pages')]")));
        personalclick.click();
        //click on add new 
        WebElement addnew = driver.findElement(By.cssSelector(".uploader.pull-right"));
        addnew.click();
        //page title
        WebElement title = driver.findElement(By.cssSelector("#template_name"));
        title.sendKeys("abrar salman");
        // click on next
        WebElement next = driver.findElement(By.cssSelector("#btn-text"));
        next.click();
        // click on next
        WebElement next1 = driver.findElement(By.cssSelector("button[class='next-button']"));
        next1.click();
        // section heading
        WebElement secheading = driver.findElement(By.xpath("//input[@name='event_block_header_label']"));
        secheading.sendKeys("kaif aslam");

        WebElement checkElement = driver.findElement(By.xpath("//input[@id='payment_option_one_time']"));
        checkElement.click();
        // Thread.sleep(5000);
        // WebDriverWait waitofselector = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement select = waitofselector.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--focus select2-container--above']//input[@role='textbox']")));
        // js.executeScript("arguments[0].scrollIntoView();", select);
        WebElement sel = driver.findElement(By.xpath("//select[@id='one_time_event']"));
        Select drop = new Select(sel);
        drop.selectByVisibleText("13 july");
        //click on check2
        WebElement checkElement2 = driver.findElement(By.xpath("//input[@id='payment_option_recurring']"));
        js.executeScript("arguments[0].scrollIntoView();", checkElement2);
        checkElement2.click();
        //select one event2
        WebElement selecElement = driver.findElement(By.xpath("//select[@id='recurring_event']"));
        Select drop2Select = new Select(selecElement);
        drop2Select.selectByVisibleText("19febtest");
        // Title
        WebElement tiElement = driver.findElement(By.cssSelector("input[name='form_title']"));
        js.executeScript("arguments[0].scrollIntoView();", tiElement);
        tiElement.sendKeys("Kaif Aslam");

        Random rnd = new Random();
        int rn = rnd.nextInt(1000);
        WebElement url = driver.findElement(By.cssSelector("#page_url"));
        url.sendKeys("Unique"+rn);
        //payment methods type
        WebElement paymethod = driver.findElement(By.cssSelector("input[value='cc']"));
        js.executeScript("arguments[0].scrollIntoView();", paymethod);
        paymethod.click();
        //payment2 methods type
        WebElement paymethod2 = driver.findElement(By.cssSelector("input[value='ec']"));
        paymethod2.click();

        //submit
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[87]/div[1]/input[1]"));
        js.executeScript("arguments[0].scrollIntoView();", submit);
        submit.click();
        //
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[@id='systemMessagesDiv']/div[1]/div[1]/div[1]/button[1]")).click();
        //copy URL
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/a[1]")).click();
        ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
        op.addArguments("incognito");
        WebDriver driver1 = new ChromeDriver(op); 
        driver1.manage().window().maximize();
        driver1.get("https://www.givecentral.org/Unique"+rn);
        JavascriptExecutor js1 = (JavascriptExecutor)driver1;
        //fill form
        Thread.sleep(4000);
        //fname
        WebElement fname = driver1.findElement(By.xpath("//input[@name='firstName']"));
        js1.executeScript("arguments[0].scrollIntoView();", fname);
        fname.sendKeys("abrar");
        //lname
        WebElement lname = driver1.findElement(By.xpath("//input[@name='familyLastName']"));
        lname.sendKeys("khan");
        //email
        driver1.findElement(By.xpath("//input[@name='email']")).sendKeys("abrar@nuclaysolutions.com");
        //address
        driver1.findElement(By.xpath("//input[@name='address']")).sendKeys("sansarpur");
        //state
        WebElement state = driver1.findElement(By.xpath("//select[@id='state']"));
        js1.executeScript("arguments[0].scrollIntoView();", state);
        Select st = new Select(state);
        st.selectByValue("CA");
        //city
        driver1.findElement(By.xpath("//input[@name='city']")).sendKeys("saharanpur");
        //zip
        driver1.findElement(By.xpath("//input[@name='zip']")).sendKeys("12121");
        //amount
        driver1.findElement(By.xpath("//input[@name='recurr_gen_amount']")).sendKeys("0.05");
        //add frequency
        WebElement af = driver1.findElement(By.xpath("//select[@name='recurr_payment_frequency']"));
        Select cf = new Select(af);
        cf.selectByVisibleText("One-Time");
        //add parish
        WebElement parish = driver1.findElement(By.xpath("//select[@name='selectMultipleParishRecurr']"));
        js1.executeScript("arguments[0].scrollIntoView();", parish);
        Select par = new Select(parish);
        par.selectByVisibleText("Immaculate Conception Parish - 9 (106)");
        //name on card
        driver1.findElement(By.xpath("//input[@name='cc_name_on_card']")).sendKeys("Abrar");
        //card number
        driver1.findElement(By.xpath("//input[@id='cc_card_no']")).sendKeys("4242424242424242");
        //select month
        WebElement month = driver1.findElement(By.xpath("//select[@name='sel_month']"));
        js1.executeScript("arguments[0].scrollIntoView();", month);
        Select mon = new Select(month);
        mon.selectByVisibleText("02");
        //select year
        WebElement year = driver1.findElement(By.xpath("//select[@name='sel_year']"));
        Select yer = new Select(year);
        yer.selectByVisibleText("2025");
        //cvv
        driver1.findElement(By.xpath("//input[@id='cc_cvv']")).sendKeys("121");
        //zip
        driver1.findElement(By.xpath("//input[@id='cc_zip']")).sendKeys("12121");
        //submit form
        driver1.findElement(By.xpath("//input[@id='makePaymentBtn']")).submit();
		//click on submit again
        Thread.sleep(2000);
        driver1.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        //close driver
//        Thread.sleep(10000);
//        driver1.close();
    }
    static String usingRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
      }
    
}
