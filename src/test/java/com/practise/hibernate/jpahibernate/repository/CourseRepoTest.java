package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import com.practise.hibernate.jpahibernate.entity.Review;
import com.practise.hibernate.jpahibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    EntityManager em;

   private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @Test
    @Transactional
    @DirtiesContext
    public void retrieveReviewsForCourse() {
        Course course = courseRepo.findById(1002L);
        logger.info("{}", course.getReviews());
    }


    @Test
    @DirtiesContext
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class,5002L);
        logger.info("{}", review.getCourse());
    }

    @Test
    @DirtiesContext
    @Transactional
    public void retrieveCoursesFromStudents() {
        Student student = em.find(Student.class, 2001L);
        logger.info("student -> {} ", student);
        logger.info("student -> {} ",student.getCourses());
    }

    @Test
    @DirtiesContext
    @Transactional
    public void addCourseToStudent() {
        Student student = em.find(Student.class, 2001L);
        Course course = new Course("Learn Data Scienece");
        student.addCourses(course);
        em.persist(student);
        logger.info("Student -{}", student);
        logger.info("Courses after updation -{}", student.getCourses());

    }


 }
