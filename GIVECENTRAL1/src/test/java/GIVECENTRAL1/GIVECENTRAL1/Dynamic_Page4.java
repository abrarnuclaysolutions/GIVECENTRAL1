package GIVECENTRAL1.GIVECENTRAL1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

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
@Listeners(com.utility.Listenerclass.class)
public class Dynamic_Page4 extends BaseClass {
	@Test
	public void DynamicPage4() throws InterruptedException {
		abcdemo ab = new abcdemo();
		String password = ab.pass;
		String username = ab.username;
		driver.get("https://www.givecentral.org/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		// object of javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Login...
		// user name
		Thread.sleep(3000);
		WebDriverWait waitofusername = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementofusername = waitofusername
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
		elementofusername.sendKeys(username);

		// password
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys(password);

		// login button
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();
		
		//Click on got it
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='driver-popover-next-btn']")).click();
       
		//remove popup
        Thread.sleep(5000);
        WebElement icon = driver.findElement(By.xpath("//a[@class='bottomContentLink' and @id='popup_modal_remind_later']"));
        js.executeScript("arguments[0].scrollIntoView();", icon);
        icon.click();
		// click on Dynamic pages
		Thread.sleep(5000);
		WebDriverWait dynamicwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement clickdynamic = dynamicwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Dynamic Pages']")));
		js.executeScript("arguments[0].scrollIntoView();", clickdynamic);
		clickdynamic.click();
		// click on personalized giving pages
		Thread.sleep(4000);
		WebDriverWait personalwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement personalclick = personalwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Personalized Giving Pages')]")));
		personalclick.click();
		// click on add new
		WebElement addnew = driver.findElement(By.cssSelector(".uploader.pull-right"));
		addnew.click();
		// page title
		WebElement title = driver.findElement(By.cssSelector("#template_name"));
		title.sendKeys("abrar salman");
		// click on next
		WebElement next = driver.findElement(By.cssSelector("#btn-text"));
		next.click();
		// hover and click the element
		WebElement themeclick = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/a[1]"));
		// Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(themeclick).build().perform();
		Thread.sleep(4000);
		WebElement templaElement = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/a[1]"));
		templaElement.click();
		// click on next
		WebElement next1 = driver.findElement(By.cssSelector("button[class='next-button']"));
		next1.click();
		// section heading
		WebElement secheading = driver.findElement(By.xpath("//input[@name='event_block_header_label']"));
		secheading.sendKeys("kaif aslam");

		// check on multiple event
		Thread.sleep(2000);
		WebElement mpl = driver.findElement(By.xpath(
				"//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[11]/div[4]/div[1]/label[2]/input[1]"));
		mpl.click();

		// add group
		Thread.sleep(2000);
		WebElement ag = driver.findElement(By.xpath("//input[@id='AddGroup']"));
		js.executeScript("arguments[0].scrollIntoView();", ag);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", ag);
		ag.click();
		// group label
		WebElement gl = driver.findElement(By.xpath("//input[@id='groupLabel1']"));
		gl.sendKeys("Nothing");
		// click on select event
		WebElement cse = driver.findElement(By.xpath("//select[@id='groupMulEvent1']"));
		// select event
		Select st = new Select(cse);
		st.selectByVisibleText("nodesg");
		st.selectByVisibleText("nodesig2");
		// add group
		Thread.sleep(2000);
		WebElement ag1 = driver.findElement(By.xpath("//input[@id='AddGroup']"));
//        js.executeScript("arguments[0].scrollIntoView();", ag);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", ag);
		ag1.click();
		// group label
		WebElement gl1 = driver.findElement(By.xpath("//input[@id='groupLabel2']"));
		gl1.sendKeys("Nothing1");
		// click on select event
		Thread.sleep(4000);
		WebElement cse1 = driver.findElement(By.xpath("//select[@id='groupMulEvent2']"));
		// select event
		Select st1 = new Select(cse1);
		st1.selectByVisibleText("nodesg");
		st1.selectByVisibleText("nodesig2");

		// select logo image
		WebElement li = driver.findElement(By.xpath("//input[@id='formLogo']"));
		js.executeScript("arguments[0].scrollIntoView();", li);
		li.sendKeys("/Users/harendersingh/Desktop/screenshotGC/Screenshot 2023-07-29 at 1.30.12 AM.png");
		// select bg image
		WebElement bg = driver.findElement(By.xpath("//input[@id='bgImage']"));
		bg.sendKeys("/Users/harendersingh/Desktop/screenshotGC/Screenshot 2023-07-29 at 1.30.12 AM.png");
		//enter title 
		WebElement title1 = driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[31]/div[2]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", title1);
		title1.sendKeys("kaif");
		//enter URL
		Random rn = new Random();
		int data = rn.nextInt(10000);
		System.out.print(data);
		WebElement url = driver.findElement(By.xpath("//input[@id='page_url']"));
		url.sendKeys("Unique"+data);
		// payment method type 1
		WebElement paymethod = driver.findElement(By.cssSelector("input[value='cc']"));
		js.executeScript("arguments[0].scrollIntoView();", paymethod);
		paymethod.click();
		// payment2 method type 2
		WebElement paymethod2 = driver.findElement(By.cssSelector("input[value='ec']"));
		paymethod2.click();
		// submit
		WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		submit.click();
		Thread.sleep(4000);
//		driver.get("https://www.givecentral.org/admin/show-appeal-pages/add-new-form");
		//click on close
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='close' and @type='button' and @data-dismiss='modal']")).click();
//        //copy URL
        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/a[1]")).click();
//        //close driver
//        Thread.sleep(5000);
//        driver.close();
        //open url
//        op.addArguments("--remote-allow-origins=*");
        ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
        op.addArguments("incognito");
        WebDriver driver1 = new ChromeDriver(op); 
        driver1.manage().window().maximize();
        driver1.get("https://www.givecentral.org/Unique"+data);
        JavascriptExecutor js1 = (JavascriptExecutor)driver1;
        //fill form
        Thread.sleep(5000);
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
        Select st11 = new Select(state);
        st11.selectByValue("CA");
        //city
        driver1.findElement(By.xpath("//input[@name='city']")).sendKeys("saharanpur");
        //zip
        driver1.findElement(By.xpath("//input[@name='zip']")).sendKeys("12121");
        //click on check button
//        driver.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]")).click();
        //amount
        driver1.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/label[2]/input[1]")).sendKeys("0.05");
        //add frequency
        WebElement af = driver1.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/label[2]/select[1]"));
        Select cf = new Select(af);
        cf.selectByVisibleText("One-Time");
        // add destination
        WebElement des = driver1.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/label[2]/select[1]"));
        Select adddes = new Select(des);
        adddes.selectByVisibleText("In memory of");
//        //add parish
//        WebElement parish = driver1.findElement(By.xpath("//select[@name='selectMultipleParishRecurr']"));
//        js1.executeScript("arguments[0].scrollIntoView();", parish);
//        Select par = new Select(parish);
//        par.selectByVisibleText("Immaculate Conception Parish - 9 (106)");
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
//        //close driver
////        Thread.sleep(10000);
//        driver1.close();
        }
}
