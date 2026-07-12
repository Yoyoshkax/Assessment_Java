package ui.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleModalWindowPage {

    private WebDriver driver;


    private static final String URL = "https://aqa-proka4.org/sandbox/web";
    private static final By SIMPLE_MODAL_XPATH = By.xpath("//section[@id='modals']/div[2]");
    private static final By SIMPLE_MODAL_WINDOW_BUTTON_XPATH = By.xpath("//section[@id='modals']/div[2]/button[@id='openModalBtn']");
    private static final By SIMPLE_HIDDEN_MODAL_WINDOW_XPATH = By.xpath("//section[@id='modals']/div[2]/div[contains(@class, 'z-50') and contains(@class, 'hidden')]");
    private static final By SIMPLE_OPENED_MODAL_WINDOW_XPATH = By.xpath("//section[@id='modals']/div[2]/div[contains(@class, 'z-50') and contains(@class, 'flex')]/div[1]");
    private static final By SIMPLE_MODAL_WINDOW_CLOSE_BUTTON_XPATH = By.xpath("//section[@id='modals']/div[2]/div[1]/div[3]/button[@id='closeModalBtn']");
    private static final By SIMPLE_MODAL_WINDOW_OK_BUTTON_XPATH = By.xpath("//section[@id='modals']/div[2]/div[1]/div[3]/button[@id='confirmModalBtn']");

    public SimpleModalWindowPage(WebDriver driver) {
        this.driver = driver;
    }

    public SimpleModalWindowPage open() {
        driver.get(URL);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SIMPLE_MODAL_XPATH));
        return this;
    }
    public void clickButtonToTriggerModalWindow() {
        driver.findElement(SIMPLE_MODAL_WINDOW_BUTTON_XPATH).click();
    }
}
