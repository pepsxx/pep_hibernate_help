package ru.pepsxx.hibernate.help.v015_one_to_one;

import jakarta.persistence.*;

@Entity
//@Table(name = "people")
public class People {

    public People(){}

    public People(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private long id;

//    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "people")
    private Address address;

}
