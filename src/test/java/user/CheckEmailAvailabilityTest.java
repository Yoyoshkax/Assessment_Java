package user;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckEmailAvailabilityTest {

    User user;
    UserClient userClient;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        user = new User("TestUser", "testUser@gmail.com", "123321", "https://i.imgur.com/OmrLsDz.jpeg");
    }

    @Test
    @DisplayName("Проверка допусности емейла для регистрации")
    public void checkEmailAvailability() {
        System.out.println(user.getEmail());
        Response userResponse = userClient.emailAvailablitiy(user.getEmail());
        boolean isAvailabile = userResponse.jsonPath().getBoolean("isAvailable");
        assertFalse(isAvailabile);
    }
}
