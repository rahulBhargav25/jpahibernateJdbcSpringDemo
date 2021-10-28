package com.practise.hibernate.jpahibernate.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", student=" + student +
                ", number='" + number + '\'' +
                '}';
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(nullable = false)
    private String number;

    public Passport(long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Passport() {

    }

    public Passport(String number) {
        this.number=number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
