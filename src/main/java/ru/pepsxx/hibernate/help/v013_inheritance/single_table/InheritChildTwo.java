package ru.pepsxx.hibernate.help.v013_inheritance.single_table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class InheritChildTwo extends InheritParent {

    public InheritChildTwo(){}

    public InheritChildTwo(String parentField, String childTowField) {
        super(parentField);
        this.childTowField = childTowField;
    }

    @Column(name = "child_two_field")
    private String childTowField;
}
