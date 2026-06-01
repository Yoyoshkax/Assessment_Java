package user;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class DataGenerator {
    private static final String DEFAULT_AVATAR = "https://i.imgur.com/OmrLsDz.jpeg";
    private static final Random random = new Random();

    private static int getRandomNumber() {
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
}
