package cn.ibubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: uncle
 * @apdateTime: 2017/11/1
 * @describe: 暂无
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class TestLogger {

    private final Logger logger = LoggerFactory.getLogger(TestLogger.class);

    @Test
    public void test1() {
        logger.debug("debug...");
        logger.info("info...");
        logger.error("error...");
    }
}
