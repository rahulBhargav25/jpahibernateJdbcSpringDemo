package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Passport;
import com.practise.hibernate.jpahibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
public class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class,2001L);
        logger.info("student -> {} ", student);
        logger.info("student -> {} ",student.getPassport());
    }

    @Test
    @Transactional
    public void sometest() {
        //db operation 1 - retrieve student
        Student student = em.find(Student.class,2001L);

        //get passport
        Passport passport = student.getPassport();
        em.flush();
        //update passport number
        passport.setNumber("E123457");


        //update Student
        student.setName("Ranga - updated");
        em.flush();
    }

    @Test
    @Transactional
    public void retrievePassportAndStudentDetails() {
        Passport passport = em.find(Passport.class,4001L);
        logger.info("passport -> {} ", passport);
        logger.info("student -> {} ",passport.getStudent());
    }

    @Test
    @Transactional
    void deleteById_test() {

        studentRepo.deleteById(2001L);

    }



}
