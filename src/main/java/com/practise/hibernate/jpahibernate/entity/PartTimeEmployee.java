package com.practise.hibernate.jpahibernate.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{

    protected PartTimeEmployee() {}

    private BigDecimal hourlyWage;

    public PartTimeEmployee(String name,BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
