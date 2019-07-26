package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookAddFriendWait {
	
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {
		navegarFacebook("https://facebook.com");
		
		ingresarFacebook("omar.selenium.abril@gmail.com", "Test@1234");
		
		buscarAmigo("Martin Contreras");
		
		agregarAmigo("Martin Contreras", "Magth Nto");

	}

	private static void navegarFacebook(String url) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		driver = new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		wait = new WebDriverWait(driver, 15);
	}

	private static void ingresarFacebook(String user, String pass) {
		// encontrar el elemento de usuario
		WebElement userNameBox = driver.findElement(By.id("email"));
		// ingresar el usuario dela variable 'user'
		userNameBox.sendKeys(user);
		//encontrar el elemento de Password
		WebElement passwordBox = driver.findElement(By.id("pass"));
		// ingresar el password de la variable 'pass'
		passwordBox.sendKeys(pass);
		//encontrar el boton que dice 'Log In'
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		// darle click
		loginButton.click();
		
	}

	private static void buscarAmigo(String amigo) {
		// encontrar el campo de busqueda
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys(amigo);
		// ingresar el nombre de mi amigo de la variable 'amigo'
		
		// esperar a que aparezcan las opciones de la lista
		// id = "facebar_typeahead_view_list"
		
		String searchListXpath = "//*[@data-testid='search_typeahead_view']" +
		"//*[contains(@class, 'uiContextualLayer')]";
		wait.until(
				ExpectedConditions.
				visibilityOfElementLocated(
						By.xpath(searchListXpath)
						)
				);
		wait.until(
				ExpectedConditions.
				numberOfElementsToBeMoreThan(
						By.xpath("//ul[@id='facebar_typeahead_view_list']//li[@role='row']"), 2)
				);
		WebElement searchButton = driver.
				findElement(
						By.xpath("//button[@data-testid='facebar_search_button']")
						);
		searchButton.click();
		// encontrar el boton azul
		// darle click al boton azul.
		
	}

	private static void agregarAmigo(String nombreAmigo, String hobby) {
	
		String addButtonXpath = "//*[contains(@id, 'xt_uniq_') and contains(., '" + hobby +"')]//button[contains(@class, 'FriendRequestAdd' )]";
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addButtonXpath)));
			addButton.click();
			
			String addedButtonXpath = "//*[contains(@id, 'xt_uniq_') and contains(., '" + hobby +"')]//button[contains(@class, 'FriendRequestOutgoing' )]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addedButtonXpath)));
	}

}
