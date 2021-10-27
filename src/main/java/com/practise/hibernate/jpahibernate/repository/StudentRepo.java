package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Passport;
import com.practise.hibernate.jpahibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepo {
    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class,id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }



    public Student save(Student student) {
        if(student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void saceStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);


    }




}
