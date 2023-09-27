package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilites.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginSteps
{
	
  
	
    WebDriver driver;
    String filepath = "C:\\Users\\ykorvi\\Desktop\\TestData.xlsx";
    WebDriverWait wait ;
    
    


    @Given("when user navigates to the BookCart application")
    public void when_user_navigates_to_the_book_cart_application() 
    {
    	
        

    	
        // Initialize WebDriver, navigate to the application, and manage timeouts and window size
        driver = new ChromeDriver();
        driver.get("https://bookcart.azurewebsites.net/");
        Options manage = driver.manage();
        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        manage.window().maximize();
        System.out.println(driver.getTitle());
        
        
        
    }

    @Given("user clicks on the login button")
    public void user_clicks_on_the_login_button() 
    
    {
        // Click on the login button
        driver.findElement(By.xpath("(//span[text()='Login'])[1]/..")).click();
    }

    @Given("user enters the username")
    public void user_enters_the_username() 
    {
        // Enter username
        
    	
    	
    	String Username = ExcelUtils.getCellValue(filepath, "Sheet1", 1, 0);
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(Username);
    	
    	
    }

    @Given("user enters the password")
    public void user_enters_the_password() {
        // Enter password
        
    	
    	String password = ExcelUtils.getCellValue(filepath, "Sheet1", 1, 1);
        driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() 
    {
        // Click on the login button to initiate login process
        driver.findElement(By.xpath("(//span[text()='Login'])[last()]/..")).click();
    }

    @Then("Login button should be success")
    public void login_button_should_be_success() {
        // Verify successful login by checking the user button's text
        String text = driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")).getText();
        System.out.println(text);
    }

    @Given("user enters the invalid username")
    public void user_enters_the_username_as_orto() {
        // Enter username for a different scenario
       
      	String Invalid_Username = ExcelUtils.getCellValue(filepath, "Sheet1", 2, 0);
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(Invalid_Username);
    	
    	
    }

    @Given("user enters the invalid password")
    public void user_enters_the_password_as_pass12() {
        // Enter password for a different scenario
        
    	

      	String Invalid_Password = ExcelUtils.getCellValue(filepath, "Sheet1", 2, 1);
        driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(Invalid_Password);
    	
    	
    }

    @Then("Login button should Fail")
    public void login_button_should_fail() {
        // Verify failed login by checking the error message
        String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
        Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
        System.out.println(text);
    }
}




