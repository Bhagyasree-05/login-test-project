import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class LoginTest {

    @Test
    public void loginAutomationTest() throws Exception {

        WebDriver driver = new ChromeDriver();

        File file = new File("login.html");
        driver.get("file:///" + file.getAbsolutePath());

        // 🔁 CHANGE THESE VALUES TO SEE PASS / FAIL
        String username = "bhagyagmail.com";
        String password = "Admin@123";

        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        String message =
                driver.findElement(By.id("message")).getText();

        // ✅ LOGIN PAGE ALWAYS SUCCESS
        Assert.assertEquals(message, "Login Successful");

        // 🔥 TEST CASE LOGIC
        if (username.equals("bhagya@gmail.com")
                && password.equals("bhagya@5656")) {

            System.out.println("VALID INPUT → TEST PASS");
            Assert.assertTrue(true);

        } else {

            System.out.println("INVALID INPUT → TEST FAIL");
            Assert.fail("Invalid credentials given");
        }

        driver.quit();
    }
}
