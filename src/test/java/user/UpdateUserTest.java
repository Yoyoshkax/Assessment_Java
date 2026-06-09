package user;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateUserTest {
    UserDto user;
    UserClient userClient;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
        user = DataGenerator.createUniqueUser();
    }

    @Test
    @DisplayName("Проверка возможности обновить данные пользователя")
    public void updateUser() {
        Response createResponse = userClient.createUser(user);
        int userId = createResponse.jsonPath().get("id");
        assertEquals(user.getName(), createResponse.jsonPath().get("name"));
        assertEquals(user.getEmail(), createResponse.jsonPath().get("email"));

        String email = DataGenerator.createUniqueNameAndEmailForUpdate().get("email");
        String name = DataGenerator.createUniqueNameAndEmailForUpdate().get("name");

        Response updateResponse = userClient.updateUser(email, name, "id", userId);
        assertEquals(email, updateResponse.jsonPath().get("email"), "Емейл юзера не обновился");
        assertEquals(name, updateResponse.jsonPath().get("name"), "Имя юзера не обновился");
    }
}
