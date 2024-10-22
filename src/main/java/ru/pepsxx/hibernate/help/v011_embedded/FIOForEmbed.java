package ru.pepsxx.hibernate.help.v011_embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FIOForEmbed {

    public FIOForEmbed() {
    }

    public FIOForEmbed(String firstName, String secondName, String thirdName) {
        FirstName = firstName;
        SecondName = secondName;
        ThirdName = thirdName;
    }

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "second_name")
    private String SecondName;

    @Column(name = "third_name")
    private String ThirdName;

}
