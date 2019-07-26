package homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicOpenCloseBrowsers {

    public static void main(String[] args) {

        //FireFox
        WebDriver firefox = new FirefoxDriver();
        firefox.manage().window().maximize();
        firefox.get("https://www.wikipedia.org/");
        firefox.quit();

        //Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mxlgonzalez\\Desktop\\chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://www.wikipedia.org/");
        chrome.manage().window().maximize();
        chrome.quit();

        //Edge
        System.setProperty("webdriver.edge.driver", "C:\\Users\\mxlgonzalez\\Desktop\\MicrosoftWebDriver.exe");
        WebDriver edge = new EdgeDriver();
        edge.get("https://www.wikipedia.org/");
        edge.manage().window().maximize();
        edge.close();

    }
}
