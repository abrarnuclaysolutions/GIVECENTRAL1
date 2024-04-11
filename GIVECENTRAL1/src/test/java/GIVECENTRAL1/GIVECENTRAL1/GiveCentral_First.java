package GIVECENTRAL1.GIVECENTRAL1;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
@Listeners(com.utility.Listenerclass.class)
public class GiveCentral_First extends BaseClass {
	@Test
	public void GC_First() throws InterruptedException {
		abcdemo ab = new abcdemo();
		String password = ab.pass;
		String username = ab.username;
		//Website URL with Location
        driver.get("https://www.givecentral.org/location/7/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
      
        //Select Event
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div.container.section-common-space:nth-child(8) div.row div.col-lg-9.col-md-7.col-sm-12 div.featured_events:nth-child(4) div.grid-box.locationEvents.dashboard-events div.grid-item.event_div:nth-child(3) div.thumbnail a:nth-child(1) div.caption > h6:nth-child(1)")).click();
        //Add amount
        driver.findElement(By.cssSelector("#amount")).sendKeys("0.01");
        // Frequency 
        WebElement element = driver.findElement(By.cssSelector("#frequency"));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Monthly");
        // Submit Value
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();     
        
        // Checkout button with Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        WebElement element2 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkoutBtn")));
        element2.click();
        
        Thread.sleep(4000);
        WebElement cont = driver.findElement(By.xpath("//a[@href='https://www.givecentral.org/login' and @class='btn btn-primary float-right btn-sm btn-mob']"));
        js.executeScript("arguments[0].scrollIntoView();", cont);
        cont.click();
        //Login 
        driver.findElement(By.cssSelector("#username")).sendKeys("kaif12345");
        driver.findElement(By.cssSelector("#password")).sendKeys("kaif12345");
        driver.findElement(By.cssSelector("#logCnf")).click();
        
        //submit after login
        driver.findElement(By.cssSelector("#submit_gift")).click(); 
	}
//	@AfterMethod
//	public void cb() {
//		driver.close();
//	}
}
