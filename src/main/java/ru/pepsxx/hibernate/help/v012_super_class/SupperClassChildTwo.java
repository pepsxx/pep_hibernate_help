package ru.pepsxx.hibernate.help.v012_super_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "supper_class_child_two")
public class SupperClassChildTwo extends SuperClassPeople {

    public SupperClassChildTwo(){}

    public SupperClassChildTwo(String name, Integer age) {
        super(name);
        this.age = age;
    }

    private Integer age;

}
