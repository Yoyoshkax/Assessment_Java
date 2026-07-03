package categories;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CategoriesClient extends BaseCategory {
    private static final String GET_AND_CREATE_CATEGORY_PATH = "/api/v1/categories";
    private static final String CATEGORY_BY_ID_PATH = "/api/v1/categories/{id}";

    @Step("Получение списка всех категорий")
    public Response getAllCategory() {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .when()
                .get(GET_AND_CREATE_CATEGORY_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Получение категории по айди номер {id}")
    public Response getSingleCategory(String param, int paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, paramValue)
                .when()
                .get(CATEGORY_BY_ID_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Удаление категории по айди {id}")
    public Response deleteSingleCategory(String param, int paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, paramValue)
                .when()
                .delete(CATEGORY_BY_ID_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Изменение категории по айди {id}")
    public Response updateSingleCategory(Map<String, String> categoryMap, String param, int paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, paramValue)
                .body(categoryMap)
                .when()
                .put(CATEGORY_BY_ID_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Создание новое категории")
    public Response createCategory(Map<String, String> categoryMap) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .body(categoryMap)
                .when()
                .post(GET_AND_CREATE_CATEGORY_PATH)
                .then()
                .extract()
                .response();
    }
}
