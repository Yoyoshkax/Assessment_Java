package ui.tests.formpagesTests;


import data.UiTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.base.BaseTest;
import ui.formpages.ValidationFormPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationFormPositiveTest extends BaseTest {

    ValidationFormPage validationFormPage;

    @BeforeEach
    public void setUp() {
        validationFormPage = new ValidationFormPage(driver);
        validationFormPage.open();
    }

    @Test
    public void testValidFormSubmisson() {
        validationFormPage
                .enterUsername(UiTestData.VALID_USERNAME)
                .enterEmail(UiTestData.VALID_EMAIL)
                .enterPassword(UiTestData.VALID_PASSWORD)
                .confirmPassword(UiTestData.VALID_PASSWORD)
                .submitForm();

        assertEquals("Все проверки пройдены! Форма валидна.", validationFormPage.getSubmitMessage().toString(), "Неправильное сообщение подтверждения валидности формы с валидацией");

    }


}
