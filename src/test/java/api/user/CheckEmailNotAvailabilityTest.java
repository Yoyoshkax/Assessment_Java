package api.user;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckEmailNotAvailabilityTest {

    EmailDto email;
    UserClient userClient;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        email = DataGenerator.createUniqueEmail();
    }

    @Test
    @DisplayName("Проверка недопусности регистрации для уже существующего в базе емейла")
    public void checkEmailNotAvailable() {
        Response userResponse = userClient.emailAvailablitiy(email);
        boolean isNotAvailabile = userResponse.jsonPath().getBoolean("isAvailable");
        assertFalse(isNotAvailabile, "Этот емейл уже зарегистрирован в системе, функция работает некорректно, позволяя зарегистировать уже имеющийся емейл");
    }
}
