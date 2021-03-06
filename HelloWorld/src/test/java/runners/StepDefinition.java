package runners;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Cucumber.class)
public class StepDefinition {

	public WebDriver driver;

	@Given("^I am on the Webpage$")
	public void i_am_on_the_webpage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\spanda\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://s3.amazonaws.com/asadcloudguru1234/index.html");
	}
	
	@When("^I enter a value in the textfield$")
    public void i_enter_a_value_in_the_textfield() throws Throwable {
		driver.findElement(By.id("textbox")).sendKeys("World");
    }

	@And("^I press the 'click Me' button$")
	public void i_press_the_click_me_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/div/button")).click();
		Thread.sleep(1000);

	}

	@Then("^the H1 header displays 'Hello WORLD'$")
	public void the_h1_header_displays_hello_world() throws Throwable {
		driver.switchTo().alert().accept();
		WebElement text = driver.findElement(By.id("my-demo"));
		String printedtext = text.getText();
		
		if(printedtext.equalsIgnoreCase("World")) {
			System.out.println("Test has Passed");
		}
		else {
			System.out.println("Test has Failed");
		}
		
	}

}