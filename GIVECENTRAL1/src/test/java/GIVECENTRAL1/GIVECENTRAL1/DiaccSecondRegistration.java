package GIVECENTRAL1.GIVECENTRAL1;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DiaccSecondRegistration extends BaseClass {
	@Test
	public void diacc_registration_form() throws InterruptedException {

		// URL
		driver.get("https://www.diacc.ae");

		// click on reg...
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")).click();
		// click on checkbox
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement checkbox = driver.findElement(By.xpath(
				"//body/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/label[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(checkbox);
		actions.perform();
		actions.click();
		checkbox.click();
		// click on start
		WebElement start = driver.findElement(By.xpath("//button[contains(text(),'START')]"));
		start.click();
		// click on media
		driver.findElement(By.xpath("//span[contains(text(),'Media')]")).click();
		// click on next
		WebElement next = driver.findElement(By.xpath(
				"//body/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/button[1]"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(next);
		actions1.perform();
		next.click();
		// enter firstname
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Abrar");
		// enter lastname
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("khan");
		// nationality
		WebElement nas = driver.findElement(By.xpath("//select[@name='nationality']"));
		Select nationality = new Select(nas);
		nationality.selectByVisibleText("India");
		// organization
		driver.findElement(By.xpath("//input[@name='organization']")).sendKeys("Checking");
		// jobtitle
		driver.findElement(By.xpath("//input[@name='job_title']")).sendKeys("tester");
		// country
		WebElement country = driver.findElement(By.xpath("//select[@name='nationality_country']"));
		Select co = new Select(country);
		co.selectByVisibleText("India");
		// address
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("sansarpur");
		// zipcode
		driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("247129");
		// phone number
		WebElement phone = driver.findElement(By.xpath("//input[@name='cell_number']"));
		Actions act = new Actions(driver);
		act.moveToElement(phone);
		act.perform();
		phone.sendKeys("9555251030");
		// phone 2
		driver.findElement(By.xpath("//input[@name='work_number']")).sendKeys("9555251030");
		// email
		Random rn = new Random();
		int num = rn.nextInt(10000);
		System.out.println(num);
		WebElement email = driver.findElement(By.xpath("//input[@name='business_email']"));
		email.sendKeys("test" + num + "@dispostable.com");
		// c email
		WebElement cemail = driver.findElement(By.xpath("//input[@name='confirm_business_email']"));
		cemail.sendKeys("test" + num + "@dispostable.com");
		// click on next
		driver.findElement(By.xpath(
				"//body/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/form[1]/div[2]/div[4]/div[5]/button[2]"))
				.click();
		// uplaod id and image
		Thread.sleep(5000);
		WebElement id = driver.findElement(By.xpath("//input[@id='files']"));
		id.sendKeys("/Users/harendersingh/Downloads/clientid.jpg");
		WebElement image = driver.findElement(By.xpath("//input[@id='photo']"));
		image.sendKeys("/Users/harendersingh/Downloads/clientimage.jpg");
		// click on next
		Thread.sleep(10000);
		WebElement next1 = driver.findElement(By.xpath(
				"//body/div[4]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/form[1]/div[3]/div[2]/div[3]/button[2]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(next1);
		act1.perform();
		act1.click();
		next1.click();
		//submit
		Thread.sleep(5000);
		int scrollAmount = 320; // Change this value as needed
		String script = "window.scrollBy(0, " + scrollAmount + ");";
		((JavascriptExecutor) driver).executeScript(script);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); // 10 seconds timeout
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
		element.click();

	}
}
