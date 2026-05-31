package user;

import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetAllUsersTest {
    UserClient userClient;

    @BeforeEach
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Получение списка всех юзеров и проверка статус кода")
    public void getAllUsersAndCheckStatusCode() {
        Response response = userClient.getAllUsers();
        int statusCode = response.statusCode();
        assertEquals(200,statusCode,"Неверный статус код");
    }

    @Test
    @DisplayName("Проверка наличия юзеров списке")
    public void checkListOfUsersInTheResponse() {
        List<Integer> userIds;
        Response response = userClient.getAllUsers();
        userIds = response.jsonPath().getList("id");
        assertTrue(!userIds.isEmpty(),"Список юзеров пустой");
        //todo подумать над обёрткой которая возвращает сразу список, с которым можно работать и не инициализировать в тесте (мб)
    }
}
