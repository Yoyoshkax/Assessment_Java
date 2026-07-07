package data;

import api.products.ProductDto;
import api.user.EmailDto;
import api.user.UserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class DataGenerator {

    private DataGenerator() {
        throw new AssertionError("Нельзя создать инстанс final класса");
    }

    private static final String DEFAULT_AVATAR = "https://i.imgur.com/OmrLsDz.jpeg";
    private static final String DEFAULT_PRODUCT_IMAGE = "https://i.imgur.com/OmrLsDz.jpeg";
    private static final String DEFAULT_CATEGORY_IMAGE = "https://i.imgur.com/OmrLsDz.jpeg";
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(1000000);
    }

    public static EmailDto createUniqueEmail() {
        return new EmailDto("testEmail" + getRandomNumber() + "@gmail.com");
    }

    public static UserDto createUniqueUser() {
        return new UserDto("User" + getRandomNumber(), "testEmail" + getRandomNumber() + "@gmail.com", "Password" + getRandomNumber(), DEFAULT_AVATAR);
    }

    public static Map<String, String> createUniqueNameAndEmailForUpdate() {
        Map<String, String> emailAndNameMap = new HashMap<>();
        emailAndNameMap.put("email", "testEmail" + getRandomNumber() + "@gmail.com");
        emailAndNameMap.put("name", "newUser" + getRandomNumber());
        return emailAndNameMap;
    }

    public static ProductDto createNewProduct() {
        return new ProductDto("TestProduct" + getRandomNumber(), getRandomNumber(), "Test description", 1, new String[]{DEFAULT_PRODUCT_IMAGE, DEFAULT_PRODUCT_IMAGE, DEFAULT_PRODUCT_IMAGE});
    }

    public static Map<String, String> createUniqueCategory() {
        Map<String, String> categoryMap = new HashMap<>();
        categoryMap.put("name", "New category" + getRandomNumber());
        categoryMap.put("image", DEFAULT_CATEGORY_IMAGE);
        return categoryMap;
    }

    public static Map<String, Object> updateProduct() {
        Map<String, Object> updatedProductTitle = new HashMap<>();
        updatedProductTitle.put("title", "New tile" + getRandomNumber());
        updatedProductTitle.put("price", getRandomNumber());
        updatedProductTitle.put("images", new String[]{DEFAULT_PRODUCT_IMAGE});
        return updatedProductTitle;
    }
}
