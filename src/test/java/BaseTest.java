import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
public static WebDriver driver = null;
public static WebDriverWait wait;
    public static String url = "";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public static void chooseDesiredPlaylist() {
        WebElement choosePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        choosePlaylist.click();
    }

    public static void deletePlaylistButton(){
        WebElement delPlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        delPlaylistButton.click();
    }

    public static void deletePlaylistOk() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ok']")));
        deletePlaylist.click();

//public static void notificationValidation() {
//    WebElement notification = driver.findElement(By.cssSelector("div[@class=success.show]"));
//            Assert.assertTrue(notification.isDisplayed());
//        }
    }

    @BeforeMethod
    @Parameters ({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url=BaseUrl;
        navigateToPage();
      wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    public static void navigateToPage() {
        driver.get(url);
    }
    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys(email);

    }
    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit(){

        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }
}