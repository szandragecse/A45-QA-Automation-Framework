import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {
        navigateToPage();
        WebElement registration = driver.findElement(By.cssSelector("a#hel"));
        registration.click();

        WebElement registrationEmailField = driver.findElement(By.cssSelector("input#email"));
        registrationEmailField.clear();
        registrationEmailField.click();
        registrationEmailField.sendKeys("sandra.geche@gmail.com");
        WebElement registerButton = driver.findElement(By.cssSelector("input#button"));
        registerButton.click();

        String expectedUrl = "https://bbb.testpro.io/registration.php";
        String actualUrl = driver.getCurrentUrl();
        assert expectedUrl.equals(actualUrl) : "ExpectedUrl" + expectedUrl + "ActualUrl" + actualUrl;
    }
}
