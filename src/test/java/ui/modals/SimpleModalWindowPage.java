package ui.modals;

import org.openqa.selenium.By;

public class SimpleModalWindowPage {

    private static final By SIMPLE_MODAL_XPATH = By.xpath("//section[@id='modals']/div[2]");
    private static final By SIMPLE_MODAL_WINDOW_BUTTON_XPATH = By.xpath("//section[@id='modals']/div[2]/button[@id='openModalBtn']");
    private static final By SIMPLE_MODAL_WINDOW_XPATH = By.xpath("//section[@id='modals']/div[2]/div[2]");
    private static final By SIMPLE_MODAL_WINDOW_CLOSE_BUTTON_XPATH = By.xpath("//section[@id='modals']/div[2]/div[1]/div[3]/button[@id='closeModalBtn']");
    private static final By SIMPLE_MODAL_WINDOW_OK_BUTTON_XPATH = By.xpath("//section[@id='modals']/div[2]/div[1]/div[3]/button[@id='confirmModalBtn']");

}
