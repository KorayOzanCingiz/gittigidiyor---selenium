import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {
    @Test()
    public void openHomePage() {
        try {
            boolean result = homePage.openHomePage();
            if (result) {
                log.debug("Home page is opened.");
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Test()
    public void checkSearch() {
        homePage.checkSearch("bilgisayar");
    }
}
