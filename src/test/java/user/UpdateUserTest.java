package user;

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
        assertEquals(user.getName(),createResponse.jsonPath().get("name"));
        assertEquals(user.getEmail(),createResponse.jsonPath().get("email"));
        Response updateResponse = userClient.updateUser(user,"id",userId);
        //todo добить генератор уникальных емейлов и имён, вкрячить здесь
    }
}
