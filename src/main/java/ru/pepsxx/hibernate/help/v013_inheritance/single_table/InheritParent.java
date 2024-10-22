package ru.pepsxx.hibernate.help.v013_inheritance.single_table;

import jakarta.persistence.*;

@Entity
@Table(name = "inherit_single_table_parent")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "disc_col")
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
