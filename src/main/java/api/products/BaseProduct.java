package api.products;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseProduct {

    private static final String BASE_PRODUCT_URL = "https://api.escuelajs.co";

    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_PRODUCT_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
