package user;

import java.util.Random;

public abstract class EmailDataGenerator {
    private static final Random random = new Random();

    private static int getRandomNumber() {
        return random.nextInt(1000000);
    }
    public static EmailDto createUniqueEmail() {
        return new EmailDto("testEmail" + getRandomNumber() + "@gmail.com");
    }
}
