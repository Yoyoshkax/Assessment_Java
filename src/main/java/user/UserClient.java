package user;

import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseUser {

    private static final String USER_OPERATION_PATH = "/api/v1/users";
    private static final String SINGLE_USER_PATH = "/api/v1/users/{id}";
    private static final String CHECK_EMAIL_AVAILABILITY_PATH = "/api/v1/users/is-available";

    @Step("Создаем пользователя")
    public Response createUser(UserDto user) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .body(user)
                .when()
                .post(USER_OPERATION_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Получаем список всех пользователей")
    public Response getAllUsers() {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .when()
                .get(USER_OPERATION_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Получаем информацию об одном пользователе")
    public Response getSingleUser(String param, int paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, paramValue)
                .when()
                .get(SINGLE_USER_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Обновляем информацию о пользователе")
    public Response updateUser(String email, String name, String param, int paramValue) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("name", name);
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, paramValue)
                .body(requestBody)
                .when()
                .put(SINGLE_USER_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Проверяем зарегистрирован ли емейл в системе")
    public Response emailAvailablitiy(EmailDto email) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .body(email)
                .when()
                .post(CHECK_EMAIL_AVAILABILITY_PATH)
                .then()
                .extract()
                .response();
    }
}
