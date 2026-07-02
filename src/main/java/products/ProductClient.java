package products;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductClient extends BaseProduct {

    private static final String GET_AND_CREATE_PRODUCTS_PATH = "/api/v1/products";
    private static final String PRODUCT_BY_ID_PATH = "/api/v1/products/{id}";
    private static final String GET_ONE_PRODUCT_BY_SLUG_PATH = "/api/v1/products/slug/{slug}";

    @Step("Получаем список всех продуктов")
    public Response getAllProducts() {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .when()
                .get(GET_AND_CREATE_PRODUCTS_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Получаем продукт по {id}")
    public Response getSingleProduct(String param, int paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param,paramValue)
                .when()
                .get(PRODUCT_BY_ID_PATH)
                .then()
                .extract()
                .response();

    }
    @Step("Создаем продукт")
    public Response createProduct(ProductDto product) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .body(product)
                .when()
                .post(GET_AND_CREATE_PRODUCTS_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Изменяем карточку товара")
    public Response updateProduct(String param, int paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, paramValue)
                .when()
                .put(PRODUCT_BY_ID_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Удаляем карточку товара")
    public Response deleteProduct(String param, int paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, paramValue)
                .when()
                .delete(PRODUCT_BY_ID_PATH)
                .then()
                .extract()
                .response();
    }

    @Step("Получаем карточку товара через {slug}")
    public Response getProductBySlug(String param, String paramValue) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam(param, param)
                .when()
                .get(GET_ONE_PRODUCT_BY_SLUG_PATH)
                .then()
                .extract()
                .response();
    }
}
