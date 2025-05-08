package utils;

import com.github.javafaker.Faker;

public class CustomMethods {

    private static final Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomMessage() {
        return faker.lorem().paragraph();
    }
}
