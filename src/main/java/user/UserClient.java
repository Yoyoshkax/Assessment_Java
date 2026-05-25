package user;

import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseUser {

    private static final String USER_OPERATION_PATH = "/api/v1/users";
    private static final String SINGLE_USER_PATH = "/api/v1/users/{id}";
    private static final String CHECK_EMAIL_AVAILABILITY_PATH = "/api/v1/users/is-available";

    @Step("Создаем пользователя")
    public ValidatableResponse createUser(UserDto user) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .body(user)
                .when()
                .post(USER_OPERATION_PATH)
                .then();
    }

    @Step("Получаем список всех пользователей")
    public ValidatableResponse getAllUsers() {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .when()
                .get(USER_OPERATION_PATH)
                .then();
    }

    @Step("Получаем информацию об одном пользователе")
    public ValidatableResponse getSingleUser() {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .when()
                .get(SINGLE_USER_PATH)
                .then();
    }

    @Step("Обновляем информацию о пользователе")
    public ValidatableResponse updateUser(UserDto user) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .when()
                .post(SINGLE_USER_PATH)
                .then();
    }

    @Step("Проверяем зарегистрирован ли емейл в системе")
    public Response emailAvailablitiy(String email) {
        Map<String,String> requestBody = new HashMap<>();
        requestBody.put("email", email);
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .body(requestBody)
                .when()
                .post(CHECK_EMAIL_AVAILABILITY_PATH)
                .then()
                .extract()
                .response();
    }
}
