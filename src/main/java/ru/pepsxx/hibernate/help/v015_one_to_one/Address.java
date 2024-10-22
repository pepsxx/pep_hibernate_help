package ru.pepsxx.hibernate.help.v015_one_to_one;

import jakarta.persistence.*;

@Entity
//@Table(name = "address")
public class Address {

    public Address(){}

    public Address(String street, People people) {
        this.street = street;
        this.people = people;

    }

//    @Column(name = "street")
    private String street;

    @Id
    @OneToOne
    @JoinColumn(name = "people_id", referencedColumnName = "id")
    private People people;
}
