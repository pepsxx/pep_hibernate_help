package ru.pepsxx.hibernate.help.v013_inheritance.joined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inherit_joined_child_one")
public class InheritChildOne extends InheritParent {

    public InheritChildOne(){}

    public InheritChildOne(String parentField, String childOneField) {
        super(parentField);
        this.childOneField = childOneField;
    }

    @Column(name = "child_one_field")
    private String childOneField;

}
