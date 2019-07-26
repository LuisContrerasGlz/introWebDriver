package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.WatchEvent;
import java.util.ArrayList;

public class RadioandCheckbox {


    public static void main(String[] args)  throws InterruptedException {

        WebDriver firefox = new FirefoxDriver();
        firefox.manage().window().maximize();
        firefox.get("http://demo.guru99.com/test/radio.html");

        //Radio Buttons
        WebElement radio1 = firefox.findElement(By.id("vfb-7-1"));
        WebElement radio2 = firefox.findElement(By.id("vfb-7-2"));
        WebElement radio3 = firefox.findElement(By.id("vfb-7-3"));

        Thread.sleep(2000);
        radio1.click();
        Thread.sleep(2000);
        radio2.click();
        Thread.sleep(2000);
        radio3.click();

        //Open new Tab

        firefox.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        ArrayList<String> tabs = new ArrayList<String> (firefox.getWindowHandles());
        firefox.switchTo().window(tabs.get(0));
        firefox.get("http://demo.guru99.com/test/radio.html");

        //Selecting Checkbox

        Thread.sleep(2000);
        firefox.findElement(By.id("vfb-6-0")).click();

        Thread.sleep(2000);
        if ( !firefox.findElement(By.id("vfb-6-1")).isSelected() )
        {
            firefox.findElement(By.id("vfb-6-1")).click();
        }

    }

}
