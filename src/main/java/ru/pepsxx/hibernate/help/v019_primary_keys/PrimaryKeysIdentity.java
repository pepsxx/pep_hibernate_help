package ru.pepsxx.hibernate.help.v019_primary_keys;

import jakarta.persistence.*;

@Entity
@Table(name = "primary_keys_identity")
public class PrimaryKeysIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

}
