package ru.pepsxx.hibernate.help.v013_inheritance.joined;

import jakarta.persistence.*;

@Entity
@Table(name = "inherit_joined_parent")
@Inheritance(strategy = InheritanceType.JOINED)
public class InheritParent {

    public InheritParent(){}

    public InheritParent(String parentField) {
        this.parentField = parentField;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "parent_field")
    private String parentField;
}
