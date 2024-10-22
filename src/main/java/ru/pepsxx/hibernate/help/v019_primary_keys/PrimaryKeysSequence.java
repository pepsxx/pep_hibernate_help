package ru.pepsxx.hibernate.help.v019_primary_keys;

import jakarta.persistence.*;

@Entity
@Table(name = "primary_keys_sequence")
public class PrimaryKeysSequence {


    @SequenceGenerator(
            name = "gen_sequence",
            sequenceName = "primary_keys_sequence_generator")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_sequence")
    long id;

}
