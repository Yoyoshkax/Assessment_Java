package user;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckEmailAvailabilityTest {

    EmailDto email;
    UserClient userClient;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        email = DataGenerator.createUniqueEmail();
    }

    @Test
    @DisplayName("Проверка недопусности уже существующего в базе емейла для регистрации")
    public void checkEmailNotAvailable() {
        Response userResponse = userClient.emailAvailablitiy(email);
        boolean isNotAvailabile = userResponse.jsonPath().getBoolean("isAvailable");
        assertFalse(isNotAvailabile, "Этот емейл уже зарегистрирован в системе, функция работает некорректно, позволяя зарегистировать уже имеющийся емейл");
    }

    @Test
    @DisplayName("Проверка несуществующего емейла в базе для регистрации")
    public void checkAvailableEmail() {
        System.out.println(email.getEmail());
        Response userResponse = userClient.emailAvailablitiy(email);
        boolean isAvailable = userResponse.jsonPath().getBoolean("isAvailable");
        assertTrue(isAvailable, "Этот емейл создаем уникальным каждый прогон теста, ожидаем всегда true");
    }
}
