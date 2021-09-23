import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver _driver;

    public LoginPage(WebDriver _driver) {
        this._driver = _driver;
    }

    private By _username = By.id("L-UserNameField");
    private By _password = By.id("L-PasswordField");
    private By _loginButton = By.id("gg-login-enter");

    public void login(String username, String password) {
        _driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");
        WebElement usernameEl = _driver.findElement(_username);
        WebElement passwordEl = _driver.findElement(_password);
        WebElement loginButtonEl = _driver.findElement(_loginButton);
        usernameEl.sendKeys(username);
        passwordEl.sendKeys(password);
        loginButtonEl.click();
    }
}
