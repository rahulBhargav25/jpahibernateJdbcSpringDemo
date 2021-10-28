package com.practise.hibernate.jpahibernate.entity;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity

@NamedQueries(
        value= {
                @NamedQuery(name="query_get_all_courses",query="Select c From Course c"),
                @NamedQuery(name="query_get_all_name_like_100_steps",query="select c From Course c where name like '%100 steps'")
        }
)
public class Course {

    @Id
    @GeneratedValue
    private long id;

    /*
    * @Column(name="fullName" ,nullable=false)
    * also change the name of the column in data.sql
    * */
    @Column(nullable = false)
    private String name;

    @UpdateTimestamp
    @Column(name="update")
    private LocalDateTime lastUpdated;

    @CreationTimestamp
    @Column(name="create")
    private LocalDateTime createdDate;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();


    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    public Course(String name) {
        this.name=name;
    }

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
