package ru.pepsxx.hibernate.help.v013_inheritance.table_per_class;

import jakarta.persistence.*;

@Entity
@Table(name = "inherit_parent")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InheritParent {

    public InheritParent(){}

    public InheritParent(String parentField) {
        this.parentField = parentField;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "parent_field")
    private String parentField;
}
