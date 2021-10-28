package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CourseSpringDataRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    CourseSpringDataRepo repo;

   private Logger logger = LoggerFactory.getLogger(this.getClass());


   @Test
    public void findById_coursePresent() {
       Optional<Course> courseOptional=repo.findById(1001L);
       assertTrue(courseOptional.isPresent());
   }

    @Test
    public void findById_courseNotPresent() {
        Optional<Course> courseOptional=repo.findById(2001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAround() {
        Course course = new Course("Microservices in 100 steps");
        repo.save(course);

        course.setName("Microservices in 100 steps - updated");
        repo.save(course);

        logger.info("Course -{}", repo.findAll());
    }

    @Test
    public void Sort_here() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        logger.info("Course -{}", repo.findAll(sort));
    }

    @Test
    public void pagination() {
        PageRequest pq = PageRequest.of(0,1);
        Page<Course> firstPage = repo.findAll(pq);
        logger.info("First page -> {}", firstPage.getContent());
        Pageable spa = firstPage.nextPageable();
        Page<Course> sp = repo.findAll(spa);
        logger.info("Second Page -> {}", sp.getContent());
    }

    @Test
    public void findUsingName() {
       logger.info("Find course name", repo.findByName("jpa in 50 steps"));
    }



}
