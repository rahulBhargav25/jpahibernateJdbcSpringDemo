package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;


    @Test
    void findById_Basic() {
        Course course = courseRepo.findById(1001L);
        assertEquals("jpa in 50 steps", course.getName());
    }

    @Test
    @DirtiesContext
    void deleteById_Basic() {
        courseRepo.deleteById(1002L);
        assertNull(courseRepo.findById(1002L));

    }

    @Test
    @DirtiesContext
    void save_Basic() {
        Course course = courseRepo.findById(1001L);
        assertEquals("jpa in 50 steps", course.getName());
        course.setName("jpa in 50 steps - updated");
        courseRepo.save(course);

        Course course1 = courseRepo.findById(1001L);
        assertEquals("jpa in 50 steps - updated",course.getName());
    }

    @Test
    @DirtiesContext
    void PlayWithem_basic() {
        courseRepo.PlayWithEm();
    }
}
