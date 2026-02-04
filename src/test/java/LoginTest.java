import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginAutomationTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/LENOVO/OneDrive/Documents/Desktop/login.html");

        // 🔹 Test inputs (change these to check pass/fail)
        String username = "wrong@gmail.com";   // change to valid later
        String password = "123";               // change to valid later

        // 🔹 Enter values
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();

        Thread.sleep(2000);

        // 🔹 UI RESULT (ALWAYS success)
        String uiResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(uiResult, "Login Successful");

        // 🔥 TESTCASE LOGIC (IMPORTANT PART)
        boolean validCredentials =
                username.equals("admin@gmail.com") &&
                password.equals("admin123");

        if (!validCredentials) {
            Assert.fail("❌ Invalid username/password - Testcase Failed");
        }

        // else → testcase PASS automatically
        driver.quit();
    }
}
