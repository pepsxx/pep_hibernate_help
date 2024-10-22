package ru.pepsxx.hibernate.help.v012_super_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "supper_class_child_one")
public class SupperClassChildOne extends SuperClassPeople {

    public SupperClassChildOne(){}

    public SupperClassChildOne(String name, String hobby) {
        super(name);
        this.hobby = hobby;
    }

    private String hobby;
}
