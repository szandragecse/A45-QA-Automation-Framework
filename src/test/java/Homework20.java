import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public static void deletePlaylist(){
        provideEmail("sandra.geche@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        chooseDesiredPlaylist();
        deletePlaylistButton();
        deletePlaylistOk();
    }
}

