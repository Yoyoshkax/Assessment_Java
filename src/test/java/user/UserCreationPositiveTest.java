package user;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCreationPositiveTest {
    private UserClient userClient;
    private User user;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        user = new User("TestUser", "testUser@gmail.com", "123321", "https://i.imgur.com/OmrLsDz.jpeg");
    }

    @Test
    @DisplayName("Создание пользователя с валидными данными")
    public void createUserWithValidData() {
        ValidatableResponse userResponse = userClient.createUser(user);
        int statusCode = userResponse.extract().statusCode();
        assertEquals(201, statusCode, "Неправильный статус код");
    }
}
