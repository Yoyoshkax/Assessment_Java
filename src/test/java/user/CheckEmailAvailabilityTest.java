package user;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Проверка несуществующего емейла в базе для регистрации")
    public void checkAvailableEmail() {
        //Сломанная ручка, на каждый новый емейл выдает false, для показа теста в теории оставляю.
        Response userResponse = userClient.emailAvailablitiy(email);
        boolean isAvailable = userResponse.jsonPath().getBoolean("isAvailable");
        assertTrue(isAvailable, "Этот емейл создаем уникальным каждый прогон теста, ожидаем всегда true");
    }
}
