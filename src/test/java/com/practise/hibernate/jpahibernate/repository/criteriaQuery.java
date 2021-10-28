package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@SpringBootTest
public class criteriaQuery {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void all_courses_without_students_criteria_query() {

        //1.use criteria Builder to create a Query returning the resultset

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq=cb.createQuery(Course.class);

        //define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
        cq.where(studentsIsEmpty);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultlist = query.getResultList();
        logger.info("Typed Query -> {}", resultlist);

    }



}
