package com.practise.hibernate.jpahibernate.entity;

import javax.persistence.*;

@Entity
public class Student {

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name=name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Student() {
        //empty constructor
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
