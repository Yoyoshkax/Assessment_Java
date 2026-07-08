package ui.formpages;

import org.openqa.selenium.By;


public class SimpleFormPage {

    private static final By USERNAME_ROW_XPATH = By.xpath("//section[@id='forms']/div[2]/form[@id='registrationForm']/div[1]/input[@id='username']");
    private static final By USER_EMAIL_ROW_XPATH = By.xpath("//section[@id='forms']/div[2]/form[@id='registrationForm']/div[2]/input[@id='email']");
    private static final By USER_PASSWORD_ROW_XPATH = By.xpath("//section[@id='forms']/div[2]/form[@id='registrationForm']/div[3]/input[@id='password']");
    private static final By USER_COUNTRY_ROW_XPATH = By.xpath("//section[@id='forms']/div[2]/form[@id='registrationForm']/div[4]/select[@id='country']");
    private static final By CHECKBOX_XPATH = By.xpath("//section[@id='forms']/div[2]/form[@id='registrationForm']/div[5]/label[1]");
    private static final By REGISTER_BUTTON_XPATH = By.xpath("//section[@id='forms']/div[2]/form[@id='registrationForm']/div[6]/button[@id='subminBtn']");

}
