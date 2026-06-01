package files;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseFile {

    private static final String BASE_FILE_URL = "https://api.escuelajs.co/api/v1/files";

    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_FILE_URL)
                .setContentType(ContentType.MULTIPART)
                .build();
    }
}
