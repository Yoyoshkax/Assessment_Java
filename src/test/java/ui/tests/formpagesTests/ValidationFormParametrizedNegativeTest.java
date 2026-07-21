package ui.tests.formpagesTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.base.BaseTest;
import ui.formpages.ValidationFormPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationFormParametrizedNegativeTest extends BaseTest {

    ValidationFormPage validationFormPage;

    @BeforeEach
    public void setUp() {
        validationFormPage = new ValidationFormPage(driver);
        validationFormPage.open();
    }

    @ParameterizedTest(name = "[{index}] {0} / {1} / {2} / {3} → ожидается: {4}")
    @CsvSource({
            "AsapRocky,123321123,123321123,TestEmail@gmail.com,'Форма содержит ошибки. Исправьте их и попробуйте снова.'",
            "Asap,123321123a,123321123a,TestEmail@gmail.com,'Форма содержит ошибки. Исправьте их и попробуйте снова.'",
            "AsapRocky,123321123a,123321123a,TestEmailgmail.com,'Форма содержит ошибки. Исправьте их и попробуйте снова.'",
            "AsapRocky,123321123,123321123a,TestEmailgmail.com,'Форма содержит ошибки. Исправьте их и попробуйте снова.'",
    })
    public void testInvalidFormSubmisson(String invalidUsername, String invalidPassword,
                                         String invalidConfirmPassword, String email,
                                         String expectedMessage) {

        validationFormPage
                .enterUsername(invalidUsername)
                .enterPassword(invalidPassword)
                .confirmPassword(invalidConfirmPassword)
                .enterEmail(email)
                .submitForm();

        assertEquals(expectedMessage, validationFormPage.getSubmitMessage(), "Сообщение об ошибке некорректное");
    }

}
