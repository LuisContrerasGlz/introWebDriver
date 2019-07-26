package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Script {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/intl/en-GB/gmail/about/");
        System.out.println(driver.getTitle());

        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector(".gmail-nav__nav-link.gmail-nav__nav-link__sign-in"));
        element.click();

        element = driver.findElement(By.id("identifierId"));
        element.sendKeys("testbeboautomation@gmail.com");

        element = driver.findElement(By.id("identifierNext"));
        element.click();

        Thread.sleep(1000);

        element = driver.findElement(By.id("passwordNext"));
        element.click();

        element = driver.findElement(By.name("password"));
        element.sendKeys("Test12345#");

        element.sendKeys(Keys.RETURN);

        driver.quit();

        /*element = driver.findElement(By.xpath(".//*[@id='password']/div[2]/div[2]"));
        System.out.println(element.getText());*/


    }

}
