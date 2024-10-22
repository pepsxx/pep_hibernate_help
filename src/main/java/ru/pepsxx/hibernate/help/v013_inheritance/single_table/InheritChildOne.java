package ru.pepsxx.hibernate.help.v013_inheritance.single_table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class InheritChildOne extends InheritParent {

    public InheritChildOne(){}

    public InheritChildOne(String parentField, String childOneField) {
        super(parentField);
        this.childOneField = childOneField;
    }

    @Column(name = "child_one_field")
    private String childOneField;

}
