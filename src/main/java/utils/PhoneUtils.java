package utils;

public class PhoneUtils {

    public static String hideMiddle(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

}
