package ui.formpages;

import org.openqa.selenium.By;

public class DymanicFormPage {
    private static final By DYNAMIC_NAME_ROW_XPATH = By.xpath("//section[@id='forms']/div[4]/form[@id='dynamicForm']/div[1]/input[@name='dyn-name']");
    private static final By DYNANIC_EMAIL_ROW_XPATH = By.xpath("//section[@id='forms']/div[4]/form[@id='dynamicForm']/div[2]/div[2]/div[1]/input[@name='email[]']");
    private static final By DYNANIC_PHONE_NUMBER_ROW_XPATH = By.xpath("//section[@id='forms']/div[4]/form[@id='dynamicForm']/div[3]/div[2]/div[1]/input[@name='phone[]']");
    private static final By ADD_EMAIL_XPATH = By.xpath("//section[@id='forms']/div[4]/form[@id='dynamicForm']/div[2]/div[1]/button[@id='addEmailBtn']");
    private static final By ADD_PHONE_NUMBER_XPATH = By.xpath("//section[@id='forms']/div[4]/form[@id='dynamicForm']/div[3]/div[1]/button[@id='addPhoneBtn']");
}
