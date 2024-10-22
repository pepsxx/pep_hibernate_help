package ru.pepsxx.hibernate.help.v013_inheritance.table_per_class;

import jakarta.persistence.*;

@Entity
@Table(name = "inherit_child_two")
public class InheritChildTwo extends InheritParent{

    public InheritChildTwo(){}

    public InheritChildTwo(String parentField, String childTowField) {
        super(parentField);
        this.childTowField = childTowField;
    }

    @Column(name = "child_two_field")
    private String childTowField;
}
