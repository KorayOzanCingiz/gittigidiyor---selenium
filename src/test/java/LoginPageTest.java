import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void login() {
        try {
            loginPage.login("koray", "123456");
            log.debug("Logged in.");
        } catch (Exception e) {
            log.error(e);
        }
    }
}
