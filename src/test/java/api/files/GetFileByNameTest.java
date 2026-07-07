package api.files;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetFileByNameTest {

    FileClient fileClient;
    File file;

    @BeforeEach
    public void setUp() {
        fileClient = new FileClient();
        file = new File("src/test/resources/TestImg.jpg");
    }

    @Test
    @DisplayName("Получаем файл по его имени")
    public void getFileByName() {
        Response fileUploadResponse = fileClient.uploadFile(file);
        String expectedFileName = fileUploadResponse.jsonPath().get("filename");

        Response getResponseByFileName = fileClient.getFile(expectedFileName);
        int statusCode = getResponseByFileName.statusCode();
        assertEquals(200, statusCode, "Неверный статус код");
        assertNotNull(getResponseByFileName);
        //todo Какая-то базовая проверка, статус код получили верный, не пустой ответ и уже неплохо, надо сохранить файл с ответа куда-то хотя бы
    }
}
