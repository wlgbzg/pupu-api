package online.pupu.api;

import lombok.extern.slf4j.Slf4j;
import utils.RandomStringUtilsV2;

@Slf4j
public class Test {
    public static void main(String[] args) {
//        System.out.println(StringUtils.joinWith("_", PhoneCodeType.Login,"1","2"));

        for (int i = 0; i < 100; i++) {
            System.out.println(RandomStringUtilsV2.randomId());
        }
    }
}
