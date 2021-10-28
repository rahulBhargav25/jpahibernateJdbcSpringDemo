package com.practise.hibernate.jpahibernate;

import com.practise.hibernate.jpahibernate.entity.FullTimeEmployee;
import com.practise.hibernate.jpahibernate.entity.PartTimeEmployee;
import com.practise.hibernate.jpahibernate.repository.CourseRepo;
import com.practise.hibernate.jpahibernate.repository.EmployeeRepo;
import com.practise.hibernate.jpahibernate.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaHIbernateApplication implements CommandLineRunner {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(JpaHIbernateApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        Course course = courseRepo.findById(1001L);
//        logger.info("curse 1001 -> {}",course);
//        courseRepo.save(new Course("Microservices in 100 steps"));
        //courseRepo.deleteById(1001L);
//        courseRepo.PlayWithEm();
          //  studentRepo.deleteById(2001L);
        //courseRepo.addReviewForCourse();

//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("Great hands on stuff","4"));
//        reviews.add(new Review("Great hands on stuff on steorids if u may say","4"));
//        courseRepo.addReviewForCourse2(1002L, reviews);
//        courseRepo.cicinati(1002L, "4");

        employeeRepo.insert(new FullTimeEmployee("jack", new BigDecimal("10000")));
        employeeRepo.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
        logger.info("All employees -> {}", employeeRepo.retrieveAllEmployees());


    }
}
