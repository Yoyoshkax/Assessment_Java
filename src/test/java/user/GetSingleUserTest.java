package user;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetSingleUserTest {
    UserClient userClient;
    UserDto user;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        user = DataGenerator.createUniqueUser();
    }

    @Test
    @DisplayName("Получение юзера по конкретному айди")
    public void getSingleUserById() {
        Response userCreateResponse = userClient.createUser(user);
        int id = userCreateResponse.jsonPath().get("id");

        Response singleUserResponse = userClient.getSingleUser("id", id);
        String email = singleUserResponse.jsonPath().get("email");
        String password = singleUserResponse.jsonPath().get("password");
        String name = singleUserResponse.jsonPath().get("name");
        String role = singleUserResponse.jsonPath().get("role");
        String avatar = singleUserResponse.jsonPath().get("avatar");

        String urlRegex = "^https?://.*";

        assertEquals(user.getEmail(), email, "Неверный емейл пользователя");
        assertEquals(user.getPassword(), password, "Неверный пароль пользователя");
        assertEquals(user.getName(), name, "Неверный пароль пользователя");
        assertEquals("customer".toUpperCase(), role.toUpperCase(), "Неверая роль пользователя");
        assertTrue(avatar.matches(urlRegex), "Аватар не является ссылкой");
    }
}
