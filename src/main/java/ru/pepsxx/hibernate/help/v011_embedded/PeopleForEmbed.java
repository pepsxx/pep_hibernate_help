package ru.pepsxx.hibernate.help.v011_embedded;

import jakarta.persistence.*;

@Entity
@Table(name = "embed_people")
public class PeopleForEmbed {

    public PeopleForEmbed(){}

    public PeopleForEmbed(String hobby, FIOForEmbed FIOForEmbed) {
        this.hobby = hobby;
        this.FIOForEmbed = FIOForEmbed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hobby;

    @Embedded
    private FIOForEmbed FIOForEmbed;

}
