package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

import static java.lang.Thread.sleep;

public class Wiki {

    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        System.out.println(driver.getTitle());

        WebElement mySelectElement = driver.findElement(By.id("searchLanguage"));
        Select dropdown= new Select(mySelectElement);

        Thread.sleep(5000);
        dropdown.selectByVisibleText("Galego");

        driver.quit();
    }
}
