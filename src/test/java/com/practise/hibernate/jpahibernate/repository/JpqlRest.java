package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest
public class JpqlRest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;


    @Test
    void findById_Basic() {
        List result = em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("Select c from Course c -> {}", result);


    }

    @Test
    void query_typed() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> result = query.getResultList();
        logger.info("Select c from Courses c",result);
    }

    @Test
    void query_where() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_name_like_100_steps", Course.class);
        List<Course> result = query.getResultList();
        logger.info("Select c from Courses c",result);
    }


}
