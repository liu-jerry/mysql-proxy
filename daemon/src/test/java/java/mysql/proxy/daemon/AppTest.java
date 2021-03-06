package java.mysql.proxy.daemon;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppTest {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    static {

    }

    @Test
    public void test01() throws Exception {
        logger.info("------------------{},{},{},{}", 1,2,3,4);

        logger.warn("------------------{},{},{},{}", 11,22,33,44);
        logger.trace("------------------{},{},{},{}", 111,222,333,444);
        logger.debug("------------------{},{},{},{}", 1111,2222,3333,4444);
        logger.info("------------------{},{},{},{}", 11111,22222,33333,44444);
        logger.error("11111");
    }
}
