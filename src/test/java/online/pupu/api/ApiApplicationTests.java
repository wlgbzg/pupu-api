package online.pupu.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ApiApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    void abd(){log.debug("你好");

        log.info("测试1");
    }
}
