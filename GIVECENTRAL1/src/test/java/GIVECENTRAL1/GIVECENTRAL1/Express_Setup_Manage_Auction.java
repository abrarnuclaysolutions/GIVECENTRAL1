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
import org.testng.annotations.Test;
//@Listeners(com.utility.Listenerclass.class)
public class Express_Setup_Manage_Auction extends BaseClass {
	@Test
	public void Manage_Auction() throws InterruptedException {
		Setup();
//		ChromeOptions op = new ChromeOptions();
//		op.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(op);
//		driver.manage().window().maximize();
		// URL
		driver.get("https://www.givecentral.org/admin");
//		javascript object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Login form
		driver.findElement(By.cssSelector("#username")).sendKeys("abrark_gc");// username
		driver.findElement(By.cssSelector("#password")).sendKeys("tiger@123456789");// password
		driver.findElement(By.cssSelector("#logCnf")).click();// login button
//		Click on Express Setup
		Thread.sleep(7000);
		WebElement es = driver.findElement(By.xpath("//span[contains(text(),'Express Setup')]"));
		es.click();
		// Click on Manage Auction
		Thread.sleep(4000);
		WebElement ma = driver.findElement(By.xpath("//span[contains(text(),'Manage Auctions')]"));
		ma.click();
		// Click on Get Started
		WebElement gt = driver.findElement(By.xpath("//a[@id='get_started']"));
		gt.click();
		Thread.sleep(5000);
		// Click on Create New Auction
		WebElement cna = driver.findElement(By.xpath("//button[contains(text(),'+ Create New Auction')]"));
		cna.click();
		// Enter Auction Detailes
		// Auction Title
		Thread.sleep(6000);
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[3]/form[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("CODING IDEs");
		// Auction Start Date
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[3]/form[1]/div[1]/div[2]/div[1]/input[2]"))
				.click();
		driver.findElement(By.xpath("//span[@class='flatpickr-day today']")).click();

		// Auction End Date
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[3]/form[1]/div[1]/div[3]/div[1]/input[2]"))
				.click();
		Thread.sleep(4000);
		WebElement ed = driver.findElement(
				By.xpath("//div[@class='dayContainer']//span[@class='flatpickr-day today']/following-sibling::span"));
		ed.click();
		// Auction Description
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[3]/form[1]/div[1]/div[4]/div[1]/textarea[1]"))
				.sendKeys("This is the Auction about most popular Programming IDEs");
		// Fundraising Goal
		WebElement frg = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[3]/form[1]/div[1]/div[6]/div[1]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", frg);
		frg.sendKeys("100");
		// Auction link
		Random rn = new Random();
		int data = rn.nextInt(10000);
		System.out.print(data);
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[3]/form[1]/div[1]/div[7]/div[1]/div[1]/input[1]"))
				.sendKeys("CODINGIDES" + data);
		// Click on create Auction
		driver.findElement(By.xpath("//button[contains(text(),'Create Auction')]")).click();
		// Click on Take me to My Auctions
		Thread.sleep(6000);
		WebElement tmtma = driver.findElement(By.xpath("//button[contains(text(),'Take me to My Auctions')]"));
		tmtma.click();
		// Click on Auction Title
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).click();
// click on add items
		Thread.sleep(5000);
		WebElement ai = driver.findElement(By.xpath("//button[contains(text(),'Add Items')]"));
		js.executeScript("arguments[0].scrollIntoView();", ai);
		ai.click();
// Add Items
		Thread.sleep(4000);
		// Title
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("ECLIPSE IDE" + data);
		// SubTitle
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys("Eclipse");
		// Description
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[3]/textarea[1]"))
				.sendKeys("Eclipse IDE is famous for Selenium WebDriver and Java");
		// Categories
		WebElement ct = driver.findElement(By.xpath("//select[@id='upg-items']"));
		Select st = new Select(ct);
		st.selectByVisibleText("Everything Else");
		// Fair market value
		WebElement fmv = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[6]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", fmv);
		fmv.sendKeys("1");
		// Starting value
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[7]/div[1]/input[1]"))
				.sendKeys("1");
		// minimun bid increment
		WebElement mbi = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[8]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", mbi);
		mbi.sendKeys("1");
		// buy now price
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[9]/div[1]/input[1]"))
				.sendKeys("1");
		// click on check
		driver.findElement(By.xpath("//input[@id='is_featured']")).click();
		// click on add items
		WebElement adit = driver.findElement(By.xpath("//button[contains(text(),'Add Item')]"));
		js.executeScript("arguments[0].scrollIntoView();", adit);
		adit.click();
		// click on okay
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='__next']/div[3]/div[2]/div[1]/div[1]/div[2]/button[1]")).click();
		// click on choose file
		Thread.sleep(3000);
		Thread.sleep(2000);
		WebElement ui = driver.findElement(By.xpath("//button[contains(text(),'Upload Image')]"));
		ui.click();
		// click on okay
		Thread.sleep(4000);
		WebElement ok = driver
				.findElement(By.xpath("//body/div[@id='__next']/div[4]/div[8]/div[1]/div[1]/div[2]/button[1]"));
		ok.click();

//	Click on Add Items second
		Thread.sleep(5000);
		WebElement ai2 = driver.findElement(By.xpath("//button[contains(text(),'Add Items')]"));
		js.executeScript("arguments[0].scrollIntoView();", ai2);
		ai2.click();
// Add Items
		Thread.sleep(3000);
		// Title
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("VISUAL STUDIO CODE IDE" + data);
		// SubTitle
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys("VS CODE");
		// Description
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[3]/textarea[1]"))
				.sendKeys("Visual Studio Code IDE is famous for its shortcuts and WebDevlopment");
		// Categories
		WebElement ct2 = driver.findElement(By.xpath("//select[@id='upg-items']"));
		Select st2 = new Select(ct2);
		st2.selectByVisibleText("Everything Else");
		// Fair market value
		WebElement fmv2 = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[6]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", fmv2);
		fmv2.sendKeys("1");
		// Starting value
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[7]/div[1]/input[1]"))
				.sendKeys("1");
		// minimun bid increment
		WebElement mbi2 = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[8]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", mbi2);
		mbi2.sendKeys("1");
		// buy now price
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[9]/div[1]/input[1]"))
				.sendKeys("1");
		// click on check
		driver.findElement(By.xpath("//input[@id='is_featured']")).click();
		// click on add items
		WebElement adit2 = driver.findElement(By.xpath("//button[contains(text(),'Add Item')]"));
		js.executeScript("arguments[0].scrollIntoView();", adit2);
		adit2.click();
		// click on okay
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='__next']/div[3]/div[2]/div[1]/div[1]/div[2]/button[1]")).click();
		// click on choose file
		Thread.sleep(3000);
		WebElement ui2 = driver.findElement(By.xpath("//button[contains(text(),'Upload Image')]"));
		ui2.click();
		// click on okay
		Thread.sleep(5000);
		WebElement ok2 = driver
				.findElement(By.xpath("//body/div[@id='__next']/div[4]/div[8]/div[1]/div[1]/div[2]/button[1]"));
		ok2.click();

// Click on Add Items third
		Thread.sleep(5000);
		WebElement ai3 = driver.findElement(By.xpath("//button[contains(text(),'Add Items')]"));
		js.executeScript("arguments[0].scrollIntoView();", ai3);
		ai3.click();
// Add Items
		Thread.sleep(3000);
		// Title
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("SUBLIME TEXT IDE" + data);
		// SubTitle
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys("SBLT");
		// Description
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[3]/textarea[1]"))
				.sendKeys("Sublime Text IDE is famous for HTML , CSS  and other Frontend framework");
		// Categories
		WebElement ct3 = driver.findElement(By.xpath("//select[@id='upg-items']"));
		Select st3 = new Select(ct3);
		st3.selectByVisibleText("Everything Else");
		// Fair market value
		WebElement fmv3 = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[6]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", fmv3);
		fmv3.sendKeys("1");
		// Starting value
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[7]/div[1]/input[1]"))
				.sendKeys("1");
		// minimun bid increment
		WebElement mbi3 = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[8]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", mbi3);
		mbi3.sendKeys("1");
		// buy now price
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[9]/div[1]/input[1]"))
				.sendKeys("1");
		// click on check
		driver.findElement(By.xpath("//input[@id='is_featured']")).click();
		// click on add items
		WebElement adit3 = driver.findElement(By.xpath("//button[contains(text(),'Add Item')]"));
		js.executeScript("arguments[0].scrollIntoView();", adit3);
		adit3.click();
		// click on okay
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[@id='__next']/div[3]/div[2]/div[1]/div[1]/div[2]/button[1]")).click();
		// click on choose file
		Thread.sleep(3000);
		WebElement ui3 = driver.findElement(By.xpath("//button[contains(text(),'Upload Image')]"));
		ui3.click();
		// click on okay
		Thread.sleep(5000);
		WebElement ok3 = driver
				.findElement(By.xpath("//body/div[@id='__next']/div[4]/div[8]/div[1]/div[1]/div[2]/button[1]"));
		ok3.click();

// Click on Add Items forth
		Thread.sleep(5000);
		WebElement ai4 = driver.findElement(By.xpath("//button[contains(text(),'Add Items')]"));
		js.executeScript("arguments[0].scrollIntoView();", ai4);
		ai4.click();
// Add Items
		Thread.sleep(3000);
		// Title
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("PYCHARM IDE" + data);
		// SubTitle
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys("PYCHARM");
		// Description
		driver.findElement(By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[3]/textarea[1]"))
				.sendKeys("Pycharm IDE is famous for python and Backend devlopment also famous for Django framework");
		// Categories
		WebElement ct4 = driver.findElement(By.xpath("//select[@id='upg-items']"));
		Select st4 = new Select(ct4);
		st4.selectByVisibleText("Everything Else");
		// Fair market value
		WebElement fmv4 = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[6]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", fmv4);
		fmv4.sendKeys("1");
		// Starting value
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[7]/div[1]/input[1]"))
				.sendKeys("1");
		// minimun bid increment
		WebElement mbi4 = driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[8]/div[1]/input[1]"));
		js.executeScript("arguments[0].scrollIntoView();", mbi4);
		mbi4.sendKeys("1");
		// buy now price
		driver.findElement(
				By.xpath("//body/div[@id='__next']/main[1]/div[1]/form[1]/div[1]/div[1]/div[9]/div[1]/input[1]"))
				.sendKeys("1");
		// click on check
		driver.findElement(By.xpath("//input[@id='is_featured']")).click();
		// click on add items
		WebElement adit4 = driver.findElement(By.xpath("//button[contains(text(),'Add Item')]"));
		js.executeScript("arguments[0].scrollIntoView();", adit4);
		adit4.click();
		// click on okay
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='__next']/div[3]/div[2]/div[1]/div[1]/div[2]/button[1]")).click();
		// click on choose file
		Thread.sleep(3000);
		WebElement ui4 = driver.findElement(By.xpath("//button[contains(text(),'Upload Image')]"));
		ui4.click();
		// click on okay
		Thread.sleep(5000);
		WebElement ok4 = driver
				.findElement(By.xpath("//body/div[@id='__next']/div[4]/div[8]/div[1]/div[1]/div[2]/button[1]"));
		ok4.click();

//click on auction shareable link
		Thread.sleep(5000);
		WebElement asl = driver.findElement(By.xpath("//button[@class='btn btn-theme w-100 mt-3']"));
		asl.click();

//open incognito mode
        ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		op.addArguments("incognito");
		WebDriver driver1 = new ChromeDriver(op);
		driver1.manage().window().maximize();
		driver1.get("https://auction.givecentral.org/live/CODINGIDES"+data);
		JavascriptExecutor js1 = (JavascriptExecutor) driver1;

		// click on current bid
		Thread.sleep(5000);
		WebElement cb = driver1.findElement(By.xpath("//div[2]/div[1]/div[1]/span[1]"));		js1.executeScript("arguments[0].scrollIntoView();", cb);
		cb.click();
		
		// second time increase bid value
//		Thread.sleep(4000);
//		WebElement ib = driver1.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']"));
//		ib.click();
		// click on place my bid
//		 Bid by sahana khan user email
		Thread.sleep(5000);
		WebElement pb = driver1.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb.click();
		// username
		Thread.sleep(10000);
		WebElement un = driver1.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un.sendKeys("sahanakhan");
		// pass
		WebElement pass = driver1.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass.sendKeys("sahana12345");
		// click on login
		Thread.sleep(5000);
		WebElement login = driver1.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login.click();

		// click on continue
		Thread.sleep(4000);
		WebDriverWait wocont = new WebDriverWait(driver1, Duration.ofSeconds(10));
		WebElement cont1 = wocont.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont1.click();
		Thread.sleep(5000);
		WebElement tmtmb1 = driver1.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb1.click();
		// close driver
		driver1.close();

//		Bid by aslam khan user email
		op.addArguments("incognito");
		WebDriver driver2 = new ChromeDriver(op);
		driver2.manage().window().maximize();
		driver2.get("https://auction.givecentral.org/live/CODINGIDES" + data);
		JavascriptExecutor js2 = (JavascriptExecutor) driver2;
//		click on current bid
		Thread.sleep(5000);
		WebElement cb1 = driver2.findElement(By.xpath("//div[2]/div[1]/div[1]/span[1]"));
		js2.executeScript("arguments[0].scrollIntoView();", cb1);
		cb1.click();
		// second time increase bid value
		Thread.sleep(4000);
		WebElement ib2 = driver2.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']"));
		ib2.click();
		// click on place my bid
		Thread.sleep(5000);
		WebElement pb1 = driver2.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb1.click();
		// username
		Thread.sleep(10000);
		WebElement un1 = driver2.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un1.sendKeys("aslamkhan");
		// pass
		WebElement pass1 = driver2.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass1.sendKeys("aslam12345");
		// click on login
		Thread.sleep(5000);
		WebElement login1 = driver2.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login1.click();

		// click on continue
		Thread.sleep(4000);
		WebDriverWait wocont1 = new WebDriverWait(driver2, Duration.ofSeconds(10));
		WebElement cont2 = wocont1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont2.click();
		Thread.sleep(5000);
		WebElement tmtmb2 = driver2.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb2.click();
		// close driver
		driver2.close();

//bid on second item by aslam khan payment 1
		op.addArguments("incognito");
		WebDriver driver3 = new ChromeDriver(op);
		driver3.manage().window().maximize();
		driver3.get("https://auction.givecentral.org/live/CODINGIDES" + data);
		JavascriptExecutor js3 = (JavascriptExecutor) driver3;

//		click on current bid
		Thread.sleep(5000);
		WebElement cb2 = driver3
				.findElement(By.xpath("//div[@class='row']//div[2]//div[@class='featured-item mb-5 mouse']//span[1]"));
		js3.executeScript("arguments[0].scrollIntoView();", cb2);
		cb2.click();
//		click on place my bid
		Thread.sleep(5000);
		WebElement pb2 = driver3.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb2.click();
//		username
		Thread.sleep(10000);
		WebElement un2 = driver3.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un2.sendKeys("aslamkhan");
//		pass
		WebElement pass2 = driver3.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass2.sendKeys("aslam12345");
//		click on login
		Thread.sleep(5000);
		WebElement login2 = driver3.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login2.click();

//		click on continue
		Thread.sleep(4000);
		WebDriverWait wocont2 = new WebDriverWait(driver3, Duration.ofSeconds(10));
		WebElement cont3 = wocont2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont3.click();
		Thread.sleep(5000);
		WebElement tmtmb3 = driver3.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb3.click();
		driver3.close();

// bid on second item by sahana khan payment 2
		op.addArguments("incognito");
		WebDriver driver4 = new ChromeDriver(op);
		driver4.manage().window().maximize();
		driver4.get("https://auction.givecentral.org/live/CODINGIDES" + data);
		JavascriptExecutor js4 = (JavascriptExecutor) driver4;

		// click on current bid
		Thread.sleep(5000);
		WebElement cb3 = driver4
				.findElement(By.xpath("//div[@class='row']//div[2]//div[@class='featured-item mb-5 mouse']//span[1]"));
		js4.executeScript("arguments[0].scrollIntoView();", cb3);
		cb3.click();
//		increase bid value
		Thread.sleep(4000);
		WebElement ib4 = driver4.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']"));
		ib4.click();
//		click on place my bid
		Thread.sleep(5000);
		WebElement pb3 = driver4.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb3.click();
		// username
		Thread.sleep(10000);
		WebElement un3 = driver4.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un3.sendKeys("sahanakhan");
		// pass
		WebElement pass3 = driver4.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass3.sendKeys("sahana12345");
		// click on login
		Thread.sleep(5000);
		WebElement login3 = driver4.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login3.click();

//		click on continue
		Thread.sleep(4000);
		WebDriverWait wocont3 = new WebDriverWait(driver4, Duration.ofSeconds(10));
		WebElement cont4 = wocont3.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont4.click();
		Thread.sleep(5000);
		WebElement tmtmb4 = driver4.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb4.click();
		driver4.close();

//		bid for third item by sahana khan user and payment 1
		op.addArguments("incognito");
		WebDriver driver5 = new ChromeDriver(op);
		driver5.manage().window().maximize();
		driver5.get("https://auction.givecentral.org/live/CODINGIDES" + data);
		JavascriptExecutor js5 = (JavascriptExecutor) driver5;

		// click on current bid
		Thread.sleep(5000);
		WebElement cb4 = driver5
				.findElement(By.xpath("//div[@class='row']//div[3]//div//span[1]"));
		js5.executeScript("arguments[0].scrollIntoView();", cb4);
		cb4.click();
//		click on place my bid
		Thread.sleep(5000);
		WebElement pb4 = driver5.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb4.click();
		// username
		Thread.sleep(10000);
		WebElement un4 = driver5.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un4.sendKeys("sahanakhan");
		// pass
		WebElement pass4 = driver5.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass4.sendKeys("sahana12345");
		// click on login
		Thread.sleep(5000);
		WebElement login4 = driver5.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login4.click();
//		click on continue
		Thread.sleep(4000);
		WebDriverWait wocont4 = new WebDriverWait(driver5, Duration.ofSeconds(10));
		WebElement cont5 = wocont4.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont5.click();
		Thread.sleep(5000);
		WebElement tmtmb5 = driver5.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb5.click();
		driver5.close();
		
//		second time bid for third item by aslam khan user payment 2
		op.addArguments("incognito");
		WebDriver driver6 = new ChromeDriver(op);
		driver6.manage().window().maximize();
		driver6.get("https://auction.givecentral.org/live/CODINGIDES" + data);
		JavascriptExecutor js6 = (JavascriptExecutor) driver6;

		// click on current bid
		Thread.sleep(5000);
		WebElement cb5 = driver6
				.findElement(By.xpath("//div[@class='row']//div[3]//div//span[1]"));
		js6.executeScript("arguments[0].scrollIntoView();", cb5);
		cb5.click();
		// increase bid value
		Thread.sleep(4000);
		WebElement ib6 = driver6.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']"));
		ib6.click();
//		click on place my bid
		Thread.sleep(5000);
		WebElement pb5 = driver6.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb5.click();
		// username
		Thread.sleep(10000);
		WebElement un5 = driver6.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un5.sendKeys("aslamkhan");
		// pass
		WebElement pass5 = driver6.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass5.sendKeys("aslam12345");
		// click on login
		Thread.sleep(5000);
		WebElement login5 = driver6.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login5.click();
		// click on continue
		Thread.sleep(4000);
		WebDriverWait wocont5 = new WebDriverWait(driver6, Duration.ofSeconds(10));
		WebElement cont6 = wocont5.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont6.click();
		Thread.sleep(5000);
		WebElement tmtmb6 = driver6.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb6.click();
		driver6.close();
		
		
		//bid for fourth item by aslam khan payment 1
		op.addArguments("incognito");
		WebDriver driver7 = new ChromeDriver(op);
		driver7.manage().window().maximize();
//	    driver.get("https://www.givecentral.org")
		driver7.get("https://auction.givecentral.org/live/CODINGIDES" + data);
		JavascriptExecutor js7 = (JavascriptExecutor) driver7;
//		click on current bid
		Thread.sleep(5000);
		WebElement cb7 = driver7
				.findElement(By.xpath("//div[@class='row']//div[4]//div//span[1]"));
		js7.executeScript("arguments[0].scrollIntoView();", cb7);
		cb7.click();
	 // click on place my bid
		Thread.sleep(5000);
		WebElement pb7 = driver7.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb7.click();
		// username
		Thread.sleep(10000);
		WebElement un7 = driver7.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un7.sendKeys("aslamkhan");
		// pass
		WebElement pass7 = driver7.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass7.sendKeys("aslam12345");
		// click on login
		Thread.sleep(5000);
		WebElement login7 = driver7.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login7.click();
//		click on continue
		Thread.sleep(4000);
		WebDriverWait wocont7 = new WebDriverWait(driver7, Duration.ofSeconds(10));
		WebElement cont7 = wocont7.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont7.click();
		Thread.sleep(5000);
		WebElement tmtmb7 = driver7.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb7.click();
		driver7.close();
		
		
		//second time bid for fourth item by sahana khan user payment2
		op.addArguments("incognito");
		WebDriver driver8 = new ChromeDriver(op);
		driver8.manage().window().maximize();
		driver8.get("https://auction.givecentral.org/live/CODINGIDES" + data);
		JavascriptExecutor js8 = (JavascriptExecutor) driver8;
		// click on current bid
		Thread.sleep(5000);
		WebElement cb8 = driver8
				.findElement(By.xpath("//div[@class='row']//div[4]//div//span[1]"));
		js8.executeScript("arguments[0].scrollIntoView();", cb8);
		cb8.click();
		// increase bid value
		Thread.sleep(4000);
		WebElement ib8 = driver8.findElement(By.xpath("//span[@class='input-group-btn']//button[@type='button']"));
		ib8.click();
		// click on place my bid
		Thread.sleep(5000);
		WebElement pb8 = driver8.findElement(By.xpath(
				"//div[@class='col-md-6 text-right']//button[@class='btn btn-theme' and contains(text(),'Place My Bid')]"));
		pb8.click();
		// username
		Thread.sleep(10000);
		WebElement un8 = driver8.findElement(By.xpath("//div//input[@id='username' and @name='email']"));
		un8.sendKeys("sahanakhan");
		// pass
		WebElement pass8 = driver8.findElement(By.xpath("//input[@id='exampleInputPassword1']"));
		pass8.sendKeys("sahana12345");
		// click on login
		Thread.sleep(5000);
		WebElement login8 = driver8.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		login8.click();
		// click on continue
		Thread.sleep(4000);
		WebDriverWait wocont8 = new WebDriverWait(driver8, Duration.ofSeconds(10));
		WebElement cont8 = wocont8.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@class='btn btn-theme' and contains(text(),'Continue')]")));
		cont8.click();
		Thread.sleep(5000);
		WebElement tmtmb8 = driver8.findElement(
				By.xpath("//button[@class='btn btn-theme p-2' and contains(text(),'Take me to My Bids')]"));
		tmtmb8.click();
		driver8.close();
//		
		//get url 	
		driver.get("https://auction.givecentral.org/my_auctions");
		driver.manage().window().maximize();
//		Thread.sleep(10000);
//		Actions act = new Actions(driver);
//		WebElement co1 = driver.findElement(By.xpath("//tbody//tr[1]//td[7]//div[1]//button[3]"));
//		js.executeScript("arguments[0].scrollIntoView();", co1);
////		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", co1);
////		co1.click();
//		Thread.sleep(5000);
//		act.moveToElement(co1).build().perform();
		
		//click on end this auction 
//		Thread.sleep(5000);
//		WebElement eta = driver.findElement(By.xpath("//button[contains(text(),'End This Auction')]"));
//		js.executeScript("arguments[0].scrollIntoView();", eta);
//		eta.click();
	}
//	@AfterMethod
//	public void cba() throws InterruptedException {
//		Thread.sleep(5000);
//		driver.close();
//	}
}
