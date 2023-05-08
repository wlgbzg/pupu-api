package utils;

import java.util.Random;

public class RandomStringUtilsV2 {
    public static final long lowerBound = 1000000000000000L;
    public static final long upperBound = 9999999999999999L;

    public static String randomId() {
        Random random = new Random();
        long id = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
        return Long.toString(id);
    }

}
