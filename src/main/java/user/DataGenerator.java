package user;

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

    //todo рассмотреть какую-то идею с интерфейсом может,т.к дублировать метод не круто.

}
