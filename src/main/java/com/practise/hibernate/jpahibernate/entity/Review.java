package com.practise.hibernate.jpahibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;


    private String description;


    private String rating;

    @ManyToOne
    private  Course course;

    public Review(long id, String description, String rating) {
        this.id = id;
        this.description = description;
        this.rating = rating;
    }

    public Review(String description, String rating) {
        this.description=description;
        this.rating=rating;
    }

    public Review(String rating) {
        this.rating=rating;
    }

    public Review(Review review) {
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Review() {

    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
