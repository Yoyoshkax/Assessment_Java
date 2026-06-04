package user;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class DataGenerator {

    private DataGenerator() {
        throw new AssertionError("Нельзя создать инстанс final класса");
    }

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
