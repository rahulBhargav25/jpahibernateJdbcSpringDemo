package com.practise.hibernate.jpahibernate.repository;

import com.practise.hibernate.jpahibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseSpringDataRepo extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> countByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> findByNameAndId(String name,Long id);
    List<Course> deleteByName(String name);

    @Query(value = "Select c From Course c where name Like '%100 steps' ")
    List<Course> courseWith100stepsNative();

    @Query(value = "Select c From Course c where name Like '%100 steps' ",nativeQuery = true)
    List<Course> courseWith100steps();

    @Query(value = "query_get_100_step_courses",nativeQuery = true)
    List<Course> courseWith100stepsNames();

}
