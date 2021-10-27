package com.practise.hibernate.jpahibernate;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaHIbernateApplicationTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    void contextLoads() {
        logger.info("here here");
    }


}
