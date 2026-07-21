package ui.formpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidationFormPage {
    WebDriver driver;
    private static final String URL = "https://aqa-proka4.org/sandbox/web";
    private static final By VALIDATION_FORM_CSS = By.cssSelector("#validationForm");
    private static final By VALIDATION_USERNAME_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[1]/input[@id='val-username']");
    private static final By VALIDATION_EMAIL_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[2]/input[@id='val-email']");
    private static final By VALIDATION_PASSWORD_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[3]/input[@id='val-password']");
    private static final By VALIDATION_CONFIRM_PASSWORD_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[4]/input[@id='val-confirm-password']");
    private static final By CONFIRM_BUTTON_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/button[@id='valSubmitBtn']");
    private static final By SUBMIT_MESSAGE = By.xpath("//div[@id='valFormResult']/descendant::p");
    private static final By PASSWORD_MATCHING_MESSAGE = By.xpath("//form[@id='validationForm']/div[4]/descendant::p");

    public ValidationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public ValidationFormPage open() {
        driver.get(URL);
        new WebDriverWait(driver, Duration.ZERO).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(VALIDATION_FORM_CSS));
        return this;
    }

    public ValidationFormPage submitForm() {
        driver.findElement(CONFIRM_BUTTON_ROW_XPATH).click();
        return this;
    }

    public ValidationFormPage confirmPassword(String password) {
        driver.findElement(VALIDATION_CONFIRM_PASSWORD_ROW_XPATH).sendKeys(password);
        return this;
    }

    public ValidationFormPage enterPassword(String password) {
        driver.findElement(VALIDATION_PASSWORD_ROW_XPATH).sendKeys(password);
        return this;
    }

    public ValidationFormPage enterUsername(String username) {
        driver.findElement(VALIDATION_USERNAME_ROW_XPATH).sendKeys(username);
        return this;
    }

    public ValidationFormPage enterEmail(String email) {
        driver.findElement(VALIDATION_EMAIL_ROW_XPATH).sendKeys(email);
        return this;
    }

    public String getSubmitMessage() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_MESSAGE));
        return messageElement.getText();
    }
}
