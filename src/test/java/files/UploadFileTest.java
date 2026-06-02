package files;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadFileTest {

    FileClient fileClient;
    File file;

    @BeforeEach
    public void setUp() {
        fileClient = new FileClient();
        file = new File("src/test/resources/TestImg.jpg");
    }

    @Test
    @DisplayName("Загружаем файл картинку")
    public void uploadRandomFile() {
        Response response = fileClient.uploadFile(file);
        int statusCode = response.statusCode();
        assertEquals(201,statusCode,"Неправильный статус код");
    }
}
