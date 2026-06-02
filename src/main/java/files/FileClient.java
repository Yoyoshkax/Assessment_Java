package files;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileClient extends BaseFile {

    private static final String UPLOAD_FILE_URL = "/upload";
    private static final String DOWNLOAD_FILE_URL = "/{filename}";

    @Step("Загружаем файл")
    public Response uploadFile(File file) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .multiPart("file", file)
                .when()
                .post(UPLOAD_FILE_URL)
                .then()
                .extract()
                .response();
    }

    @Step("Получаем файл")
    public Response getFile(String fileName) {
        return given()
                .filter(new AllureRestAssured())
                .spec(getSpec())
                .pathParam("filename", fileName)
                .when()
                .get(DOWNLOAD_FILE_URL)
                .then()
                .extract()
                .response();
    }
}
