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
import org.testng.annotations.AfterClass;
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
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;

// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Listeners(com.utility.Listenerclass.class)
public class Communication_File extends BaseClass {
	@Test
	public void Comm_file() throws InterruptedException {
		//URL
        driver.get("https://www.givecentral.org/admin/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         // object of javascript
         JavascriptExecutor js = (JavascriptExecutor)driver;
         // Login form
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
         //click on communication
         Thread.sleep(7000);
         WebDriverWait comm = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement communication = comm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Communication']")));
        js.executeScript("arguments[0].scrollIntoView();", communication);
        communication.click();
        //click on new communication
        Thread.sleep(5000);
        WebDriverWait newcomm = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement newcommunication = newcomm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='New Communication Portal (Beta)']"))); 
        js.executeScript("arguments[0].scrollIntoView();", newcommunication);
        Thread.sleep(4000);
        newcommunication.click();
        //switch to new tab
        ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newtab.get(1));
        //click on send email
        Thread.sleep(4000);
        WebElement sendemail = driver.findElement(By.xpath("//a[normalize-space()='Send Emails']"));
        sendemail.click();
        //click on new campaign
        driver.findElement(By.xpath("//h5[normalize-space()='New Campaign']")).click();
        //enter text on popup box
        driver.findElement(By.xpath("//input[@id='contacts-campaign-name']")).sendKeys("gfgzdc");
        //click on continue
        driver.findElement(By.xpath("//button[@id='add-contacts-campaign']")).click();
        //enter email
        WebElement emaileElement = driver.findElement(By.xpath("//input[@id='search-input']"));
        emaileElement.sendKeys("abrar@nuclaysolutions.com");
        Thread.sleep(2000);
        emaileElement.sendKeys(Keys.ENTER);
        // check on id
        Thread.sleep(5000);
        WebElement id = driver.findElement(By.xpath("//td[normalize-space()='fdg']//span[@class='checkmark']"));
        id.click();
        //click on continue
        WebElement contiElement = driver.findElement(By.xpath("//button[@id='continue-btn']"));
        contiElement.click();
        //click on add new template
        WebElement template = driver.findElement(By.xpath("//i[@class='fas fa-plus']"));
        template.click();
        //enter template name
        WebElement tempname = driver.findElement(By.xpath("//input[@placeholder='Enter template name']"));
        tempname.sendKeys("abrar salman");
        //click on confirm
        WebElement con = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        con.click();
        //enter text on email subject
        Thread.sleep(1000);
        WebElement emailsub = driver.findElement(By.xpath("//input[@placeholder='Enter email subject']"));
        emailsub.sendKeys("kuchbhi");
        // click on confirm
        Thread.sleep(4000);
        WebDriverWait con2wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement con2 = con2wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Confirm']")));
//        con2.click();
        Actions conc = new Actions(driver);
        conc.moveToElement(con2).click().perform();

        WebElement dragelement = driver.findElement(By.xpath("//div[@id='toolblocks']//div[2]//div[1]//div[1]"));
        WebElement dropelement = driver.findElement(By.cssSelector(".sortable-blocks-edit.empty.ui-sortable"));
        Actions act = new Actions(driver);
        act.dragAndDrop(dragelement, dropelement).click().perform();
        //select the image
        WebElement upload = driver.findElement(By.xpath("//input[@class='fileupload nofile']"));
        upload.sendKeys("/Users/harendersingh/Desktop/eclipseimg.png");
//        Actions image = new Actions(driver);
//        image.sendKeys("C:\\Users\\Cw\\Pictures\\Screenshots\\Screenshot (3).png");
        //click on save
        WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save']"));
        save.click();
        //click on exit
        WebElement exit = driver.findElement(By.xpath("//a[@id='exit-button']"));
        exit.click();
        //click on select
        Thread.sleep(3000);
        WebElement select = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/button[1]"));
        Actions act3 = new Actions(driver);
        act3.moveToElement(select).click().perform();
        //click on continue
        WebElement cont3Element = driver.findElement(By.xpath("//button[@id='continue-btn']"));
        cont3Element.click();
        //enter email again
        WebElement emailagain = driver.findElement(By.xpath("//input[@id='replyTo']"));
        js.executeScript("arguments[0].scrollIntoView();", emailagain);
        emailagain.sendKeys("abrar@nuclaysolutions.com");
        //click on continue
        WebElement cont4Element = driver.findElement(By.xpath("//button[@id='continue-btn']"));
        cont4Element.click();
        //click on send email
        Thread.sleep(3000);
        WebElement sendemail1 = driver.findElement(By.xpath("//button[contains(text(),'Send Now')]"));
//        sendemail1.click();
        Actions act4 = new Actions(driver);
        act4.moveToElement(sendemail1).click().perform();
        //click on back to dashboard
        Thread.sleep(7000);
        WebElement btdb = driver.findElement(By.xpath("//body/div[@id='emailSent']/div[1]/div[1]/div[1]/a[1]"));
        Actions btd = new Actions(driver);
        btd.moveToElement(btdb).click().perform();
	}
}
