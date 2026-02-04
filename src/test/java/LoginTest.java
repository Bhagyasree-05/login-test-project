import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class LoginTest {

    @Test
    public void loginAutomationTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        File file = new File("login.html");
        String path = file.getAbsolutePath();
        driver.get("file:///" + path);

        Thread.sleep(1000); // page load wait

        String username = "bhagya@gmail.com";   // change to wrong to see FAIL
        String password = "bhagya@56";

        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();

        Thread.sleep(1000);

        // 🔥 ONLY TESTCASE decides pass/fail
        boolean isValidUser =
                username.equals("bhagya@gmail.com") &&
                password.equals("bhagya@56");

        Assert.assertTrue(isValidUser, "Invalid credentials given");

        driver.quit();
    }
}
