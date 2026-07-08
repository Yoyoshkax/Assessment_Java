package ui.formpages;

import org.openqa.selenium.By;

public class ValidationFormPage {

    private static final By VALIDATION_USERNAME_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[1]/input[@id='val-username']");
    private static final By VALIDATION_EMAIL_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[2]/input[@id='val-email']");
    private static final By VALIDATION_PASSWORD_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[3]/input[@id='val-password']");
    private static final By VALIDATION_CONFIRM_PASSWORD_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/div[4]/input[@id='val-confirm-password']");
    private static final By CONFIRM_BUTTON_ROW_XPATH = By.xpath("//section[@id='forms']/div[3]/form[@id='validationForm']/button[@id='valSubmitBtn']");
}
