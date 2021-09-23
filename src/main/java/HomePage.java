import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage {
    private WebDriver _driver;
    static Logger log;

    private By _searchInput = By.cssSelector("input[name='k'][type='text']");
    private By _submit = By.cssSelector("button[type='submit']");
    private By _buttonList = By.cssSelector("li[class='sc-12aj18f-2 jwZJjs']");
    private By _buttons = By.id("CountSelect");

    private By _addToBasket = By.id("add-to-basket");
    private By _urunFiyatlari = By.cssSelector("li[class='sc-1nx8ums-0 dyekHG']");

    public HomePage(WebDriver _driver) {
        this._driver = _driver;
        log = Logger.getLogger(HomePage.class);
        BasicConfigurator.configure();
    }

    public boolean openHomePage() {
        _driver.get("https://www.gittigidiyor.com/");

        if(_driver.getTitle() != null && _driver.getTitle().contains("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi")){
            return  true;
        } else {
            return  false;
        }
    }

    public  void checkSearch(String searchText) {
        try {
            _driver.get("https://www.gittigidiyor.com/");

            WebElement input = _driver.findElement(_searchInput);
            WebElement submit = _driver.findElement(_submit);
            input.sendKeys(searchText);
            submit.click();

            List<WebElement> buttons = _driver.findElements(_buttonList);
            boolean found = false;
            for (WebElement button: buttons) {
                if (button.getText().equals("2")) {
                    found = true;
                }
            }

            if (found) {
                String appendedUrl = _driver.getCurrentUrl() + "&sf=2";
                log.debug("Bilgisayar arama sonuçlarında 2.sayfaya gidiliyor.");
                _driver.get(appendedUrl);

                List<WebElement> aramaSonuclari = _driver.findElements(By.xpath("//li/article/div/a[@class='sc-1n49x8z-1 izbuTw']"));
                int size = aramaSonuclari.size();
                Random random = new Random();
                int randomUrun = random.nextInt(size);
                aramaSonuclari.get(randomUrun).click();

                WebElement button = _driver.findElement(By.xpath("//ul/li/a[@class='IncNumber gg-icon gg-icon-plus']"));
                button.click();
                log.debug("Ürün adedi 2 ye çıkarıldı.");
            }
        } catch (Exception e) {
            log.error(e);
        }
    }
}
