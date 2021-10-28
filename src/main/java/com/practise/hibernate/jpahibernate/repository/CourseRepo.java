package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import com.practise.hibernate.jpahibernate.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepo {
    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Long courseId;
    private List<Review> reviews;

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


    public void addReviewForCourse() {
        //get course 1003
        Course course = findById(1003L);
        logger.info("course reviews -> {}", course.getReviews());
        Review review1 = new Review("Great stuff","5" );
        Review review2 = new Review("Great no awesome stuff", "4");
        //add 2 reviews

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        em.persist(review1);
        em.persist(review2);
        //save
    }

    public void addReviewForCourse2(Long courseId, List<Review> reviews) {
        this.courseId = courseId;
        this.reviews = reviews;
        //get course 1003
        Course course = findById(courseId);
        logger.info("course reviews -> {}", course.getReviews());

        for(Review review:reviews) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }


        //save
    }
    public void cicinati(Long id, String rating) {
        Course course = findById(id);
        List<Review> reviews = course.getReviews();

        for(int i = 0; i < reviews.size();i++) {

            if(reviews.get(i).getRating().equals(rating)) {
                em.remove(reviews.get(i));
            }
        }

    }



}
