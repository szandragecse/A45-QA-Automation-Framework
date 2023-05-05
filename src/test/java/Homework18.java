import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public static void playSong() throws InterruptedException {
        navigateToPage();
        login("sandra.geche@gmail.com", "te$t$tudent");
        Thread.sleep(2000);
        playButton();
        boolean isSoundBarDisplayed = isSoundBarDisplayed();
        Assert.assertTrue(isSoundBarDisplayed);
    }
}