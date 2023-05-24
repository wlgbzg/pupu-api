package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomStringUtilsV2 {
    public static final long lowerBound = 1000000000000000L;
    public static final long upperBound = 9999999999999999L;

    public static String randomId() {
        Random random = new Random();
        long id = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
        return Long.toString(id);
    }

    public static String randomMessageId() {
        return RandomStringUtils.randomAlphanumeric(16);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(randomMessageId());
        }
    }
}
