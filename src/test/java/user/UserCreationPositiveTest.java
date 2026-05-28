package user;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserCreationPositiveTest {
    private UserClient userClient;
    private UserDto user;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        user = new UserDto("TestUser", "testUser@gmail.com", "123321", "https://i.imgur.com/OmrLsDz.jpeg");
    }

    @Test
    @DisplayName("Проверка правильности заполнения данных пользователя")
    public void userShouldBeCreatedWithCorrectCredentials() {
        Response userResponse = userClient.createUser(user);
        String name = userResponse.jsonPath().get("name");
        String password = userResponse.jsonPath().get("password");
        String role = userResponse.jsonPath().get("role");
        String email = userResponse.jsonPath().get("email");
        String avatar = userResponse.jsonPath().get("avatar");
        int statusCode = userResponse.statusCode();

        assertEquals(201, statusCode, "Неправильный статус код");
        assertEquals(user.getName().toUpperCase(), name.toUpperCase(), "Неправильное имя пользователя");
        assertEquals(user.getPassword().toUpperCase(), password.toUpperCase(), "Неправильный пароль пользователя");
        assertEquals("customer".toUpperCase(), role.toUpperCase(), "Неправильно выдана роль для пользователя");
        assertEquals(user.getEmail().toUpperCase(), email.toUpperCase(), "Неправильно eмейл пользователя");
        //todo добить проверку с аватаром
    }
}
