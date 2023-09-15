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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.utility.Listenerclass.class)
public class AddDonor extends BaseClass {
	@Test
	public void Add_Donor() throws InterruptedException {
		abcdemo ab = new abcdemo();
		String password = ab.pass;
		String username = ab.username;
		System.out.println(password);
        driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Login...
        WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementofusername = waitofusername
                        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        elementofusername.sendKeys(username);
        // driver.findElement(By.cssSelector("#username")).sendKeys("abrark_gc");//
        // username
        WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement elementofpass = waitofpass
                        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        elementofpass.sendKeys(password);
        // driver.findElement(By.cssSelector("#password")).sendKeys("tiger@12345678");//
        // password
        WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement clicklogin = waitoflogin
                        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
        clicklogin.click();
        //remove popup
        Thread.sleep(4000);
        WebElement icon = driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='adminPageModal']/div[1]/div[1]/div[1]/button[1]/span[1]/img[1]"));
        icon.click();
        // click on donors
        Thread.sleep(10000);
        WebDriverWait waitofdonor = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementofdonor = waitofdonor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[10]/a[1]/span[1]")));
        elementofdonor.click();
        // click on add new donor
        Thread.sleep(7000);
        WebDriverWait waitofadddonor = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement elementofadddonor = waitofadddonor.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/nav[@id='sidebar']/div[1]/ul[1]/li[10]/ul[1]/li[1]/a[1]/span[1]")));
        elementofadddonor.click();
        // first name
        Thread.sleep(4000);
        WebElement fname = driver.findElement(By.cssSelector("input[name='donor_first_name']"));
        fname.sendKeys("abrar");
        // last name
        WebElement lname = driver.findElement(By.cssSelector("input[name='donor_last_name']"));
        lname.sendKeys("salman");
        // profile id
        int number;
        Random ran = new Random();
        number = ran.nextInt();
        WebElement profileid = driver.findElement(By.cssSelector("#userid"));
        profileid.sendKeys("abrark_gc" + number);
        // js object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // address
        WebElement address = driver.findElement(By.cssSelector("input[name='address1']"));
        js.executeScript("arguments[0].scrollIntoView();", address);
        address.sendKeys("Sansarpur(Saharanpur)");
        // country
        WebElement country = driver.findElement(By.cssSelector("#country"));
        js.executeScript("arguments[0].scrollIntoView();", country);
        Select sctcountry = new Select(country);
        sctcountry.selectByVisibleText("United States");
        // city
        WebElement city = driver.findElement(By.cssSelector("input[name='donor_city']"));
        js.executeScript("arguments[0].scrollIntoView();", city);
        city.sendKeys("Saharanpur");
        // state
        WebElement state = driver.findElement(By.xpath("//select[@name='donor_state']"));
        js.executeScript("arguments[0].scrollIntoView();", state);
        Select sct = new Select(state);
        sct.selectByVisibleText("California");
        // zip
        WebElement zip = driver.findElement(By.cssSelector("input[name='zip']"));
        js.executeScript("arguments[0].scrollIntoView();", zip);
        zip.sendKeys("12121");
        //enter parish id 
        WebElement parishid = driver.findElement(By.xpath("//select[@name='parishid']"));
        Select pid = new Select(parishid);
        pid.selectByVisibleText("106 - Immaculate Conception Parish - 9");
        // submit
        WebElement submit = driver.findElement(By.cssSelector("input[value='Save Donor']"));
        js.executeScript("arguments[0].scrollIntoView();", submit);
        submit.click();
        //popup
        WebElement popup = driver.findElement(By.xpath("//div[@id='systemMessagesDiv']//button[@type='button'][normalize-space()='×']"));
        popup.click();
        
	}
}
