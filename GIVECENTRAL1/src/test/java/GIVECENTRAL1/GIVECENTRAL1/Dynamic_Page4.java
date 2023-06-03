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
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Listeners(com.utility.Listenerclass.class)

public class Dynamic_Page4 extends BaseClass {
	@Test
	public void DynamicPage4() throws InterruptedException {
		Setup();
		test = extent.createTest("Dynamic_Page4");
//		ChromeOptions op = new ChromeOptions();
//		op.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(op);
//		driver.manage().window().maximize();
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
		elementofusername.sendKeys("abrark_gc");

		// password
		WebDriverWait waitofpass = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementofpass = waitofpass
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		elementofpass.sendKeys("tiger@123456789");

		// login button
		WebDriverWait waitoflogin = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement clicklogin = waitoflogin
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logCnf")));
		clicklogin.click();
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
		WebElement personalclick = personalwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body > div:nth-child(3) > div:nth-child(9) > nav:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(14) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(1)")));
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
		st.selectByVisibleText("normal25");
		st.selectByVisibleText("normal25");
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
		st1.selectByVisibleText("normal255");
		st1.selectByVisibleText("normal255");

		// select logo image
		WebElement li = driver.findElement(By.xpath("//input[@id='formLogo']"));
		js.executeScript("arguments[0].scrollIntoView();", li);
		li.sendKeys("/Users/harendersingh/Desktop/eclipseimg.png");
		// select bg image
		WebElement bg = driver.findElement(By.xpath("//input[@id='bgImage']"));
		bg.sendKeys("/Users/harendersingh/Desktop/eclipseimg.png");
		//enter title 
		WebElement title1 = driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content']/form[@id='dynamicFormBuilder']/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[31]/div[2]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", title1);
		title1.sendKeys("whatever");
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
		//click on cross icon 
//		Thread.sleep(1000);
//		WebElement ci = driver.findElement(By.xpath("//body/div[@id='systemMessagesDiv']/div[1]/div[1]/div[1]/button[1]"));
//		ci.click();
		//enter id on search bar
		Thread.sleep(1000);
		WebElement sb = driver.findElement(By.xpath("//input[@id='searchbar']"));
		sb.sendKeys("Unique"+data);
		//click on search button
		WebElement sb1 = driver.findElement(By.xpath("//button[@id='searchButton']"));
		sb1.click();
		Thread.sleep(2000);
		//copy link
		WebElement cl = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/a[1]"));
		cl.click();
//		close driver
		Thread.sleep(5000);
		driver.close();
		//open link
        ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.addArguments("incognito");
		WebDriver driver1 = new ChromeDriver(op);
        driver1.manage().window().maximize();
		driver1.get("https://pgp.givecentral.org/Unique"+data);
        JavascriptExecutor js1 = (JavascriptExecutor)driver1;

		//form fill 
		Thread.sleep(12000);
		//fname
		WebElement fname = driver1.findElement(By.xpath("//input[@name='firstName']"));
		js1.executeScript("arguments[0].scrollIntoView();", fname);
		fname.sendKeys("Abrar");
		//lname
		driver1.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Khan");
		//phone
		WebElement phone = driver1.findElement(By.xpath("//input[@id='phone']"));
		js1.executeScript("arguments[0].scrollIntoView();", phone);
		phone.sendKeys("9555251030");
		//email
		driver1.findElement(By.xpath("//input[@id='email']")).sendKeys("abrar@nuclaysolutions.com");
		//street address
		WebElement streetaddress = driver1.findElement(By.xpath("//input[@id='address']"));
		js1.executeScript("arguments[0].scrollIntoView();", streetaddress);
		streetaddress.sendKeys("sansarpur");
		//unitnumber
		driver1.findElement(By.xpath("//input[@id='unitNo']")).sendKeys("212, 212, 212");
		//country
//		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
//		Select cty = new Select(country);
//		cty.selectByValue("US");
		//state
		WebElement state = driver1.findElement(By.xpath("//select[@id='state']"));
		Select sta = new Select(state);
		sta.selectByVisibleText("California ");
		//city
		driver1.findElement(By.xpath("//input[@id='city']")).sendKeys("saharanpur");
		//zip 
		driver1.findElement(By.xpath("//input[@id='zip']")).sendKeys("12121");
		
		//select payment event normal25
		Thread.sleep(1000);
//		WebElement spe = driver.findElement(By.xpath("//input[@name='Nothing']"));
//		js.executeScript("arguments[0].scrollIntoView();", spe);
//		spe.click();
		//enter amount
		driver1.findElement(By.xpath("//input[@id='multipleOtherAmount_36318']")).sendKeys("2");
		//select frequency
		WebElement sf = driver1.findElement(By.xpath("//select[@class='form-select' and @name='selectMultipleFreq_36318']"));
		js1.executeScript("arguments[0].scrollIntoView();", sf);
		Select freq = new Select(sf);
		freq.selectByVisibleText("One Time");
		//parish
		WebElement parish = driver1.findElement(By.xpath("//select[@name='selectMultipleParish_36318']"));
		Select pari = new Select(parish);
		pari.selectByVisibleText("Immaculate Conception Parish-9(106)");
		//select payment event normal255
		WebElement spe2 = driver1.findElement(By.xpath("//input[@name='multipleAmount_36315']"));
		js1.executeScript("arguments[0].scrollIntoView();", spe2);
		spe2.sendKeys("2");
		//payment frequency
		WebElement pf2 = driver1.findElement(By.xpath("//select[@name='selectMultipleFreq_36315']"));
		Select pfs = new Select(pf2);
		pfs.selectByVisibleText("One-Time");
		//parish2
		WebElement p = driver1.findElement(By.xpath("//select[@name='selectMultipleParish_36315']"));
		Select p1= new Select(p);
		p1.selectByVisibleText("Immaculate Conception Parish-9(106)");
		
		//payment card details
		//name on card
		WebElement cn = driver1.findElement(By.xpath("//input[@id='cc_name_on_card']"));
		js1.executeScript("arguments[0].scrollIntoView();", cn);
		cn.sendKeys("Abrar");
		//card number
		driver1.findElement(By.xpath("//input[@id='cc_card_no']")).sendKeys("4242424242424242");
		//select month
		WebElement month = driver1.findElement(By.xpath("//select[@id='sel_month']"));
		Select m2= new Select(month);
		m2.selectByVisibleText("02");
		//select year
		WebElement year = driver1.findElement(By.xpath("//select[@id='sel_year']"));
		Select y= new Select(year);
		y.selectByVisibleText("2025");
		//enter cvv
		driver1.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("121");
		//select country
//		WebElement coty2 = driver.findElement(By.xpath("//select[@id='cc_country']"));
//		Select cot = new Select(coty2);
//		cot.selectByValue("US");
//		//zip
		driver1.findElement(By.xpath("//input[@name='cc_zip']")).sendKeys("12121");
		//click on preview
		Thread.sleep(4000);
		WebElement preview = driver1.findElement(By.xpath("//button[contains(text(),'Preview')]"));
		js1.executeScript("arguments[0].scrollIntoView();", preview);
		preview.submit();
		//click on submit 
		Thread.sleep(2000);
		WebElement submit2 = driver1.findElement(By.xpath("//button[@id='Submit']"));
		submit2.click();
//		close driver
//		Thread.slee/p(10000);
		driver1.close();
		
	}
//	@AfterMethod
//	public void cb() {
//		driver.close();
//	}
}
