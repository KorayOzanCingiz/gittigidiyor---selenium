import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;
    static Logger log;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeAll
    public void Setup() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.whitelistedIps", "");

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        log = Logger.getLogger(BaseTest.class);
        BasicConfigurator.configure();
    }

    @AfterAll
    public void Teardown() {
        log.trace("Test finished.");
        driver.quit();
    }
}
