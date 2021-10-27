package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepo {
    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class,id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void PlayWithEm() {
        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1);
        Course course2 = findById(1001L);
        course2.setName("Angular js in 100 steps - updated");

    }




}
