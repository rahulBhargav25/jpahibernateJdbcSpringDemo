package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class NativeTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;


    @Test
    void findById_Basic() {
        List result = em.createNativeQuery("select * from course").getResultList();
        logger.info("Select c from Course c -> {}", result);


    }

    @Test
    void param_Basic() {
        Query q = em.createNativeQuery("select * from course where id = ?", Course.class);
        q.setParameter(1,1001L);
        List result = q.getResultList();
        logger.info("select * from course where id = ?", result);


    }

    @Test
    void paramWithName_Basic() {
        Query q = em.createNativeQuery("select * from course where id = :id", Course.class);
        q.setParameter("id",1001L);
        List result = q.getResultList();
        logger.info("select * from course where id = :id", result);


    }

    @Test
    @Transactional
    public void native_queries_to_update() {
        Query q= em.createNativeQuery("Update COURSE set update=sysdate()", Course.class);
        int result = q.executeUpdate();
        logger.info("Update COURSE set update -> {}", result);
    }




}
