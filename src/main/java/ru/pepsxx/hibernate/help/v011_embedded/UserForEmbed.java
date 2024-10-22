package ru.pepsxx.hibernate.help.v011_embedded;

import jakarta.persistence.*;

@Entity
@Table(name = "embed_user")
public class UserForEmbed {

    public UserForEmbed(){}

    public UserForEmbed(String nickName, FIOForEmbed FIOForEmbed) {
        this.nickName = nickName;
        this.FIOForEmbed = FIOForEmbed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Embedded
    private FIOForEmbed FIOForEmbed;
}
