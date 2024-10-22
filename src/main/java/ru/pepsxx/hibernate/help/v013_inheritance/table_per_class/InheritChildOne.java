package ru.pepsxx.hibernate.help.v013_inheritance.table_per_class;

import jakarta.persistence.*;

@Entity
@Table(name = "inherit_child_one")
public class InheritChildOne extends InheritParent {

    public InheritChildOne(){}

    public InheritChildOne(String parentField, String childOneField) {
        super(parentField);
        this.childOneField = childOneField;
    }

    @Column(name = "child_one_field")
    private String childOneField;

}
