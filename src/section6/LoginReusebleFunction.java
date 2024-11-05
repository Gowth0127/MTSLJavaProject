package section6;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginReusebleFunction {

    // Reusable function to test login feature
    public static boolean testLogin(String username, String password, boolean expectedOutcome) {
        WebDriver driver = null;
        boolean loginSuccessful = false;
        try {          
            WebdriverManager.ChromeDriver.Setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://example.com/login");

            
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginBtn"));


            usernameField.sendKeys(username);
            passwordField.sendKeys(password);


            loginButton.click();

            
            try {
                WebElement dashboard = driver.findElement(By.id("dashboard"));
                loginSuccessful = true;  
            } catch (NoSuchElementException e) {
                loginSuccessful = false;
            }

           
            if (loginSuccessful == expectedOutcome) {
                System.out.println("Login test passed");
            } else {
                System.out.println("Login test failed");
            }

        } catch (Exception e) {
            System.out.println("Error during login test: " + e.getMessage());
        } finally {
           
            if (driver != null) {
                driver.quit();
            }
        }

        return loginSuccessful;
    }

    public static void main(String[] args) {
       
        testLogin("validUser", "validPassword", true);   
        testLogin("invalidUser", "wrongPassword", false); 
    }
}
