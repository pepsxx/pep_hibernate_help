package ru.pepsxx.hibernate.help.v019_primary_keys;

import jakarta.persistence.*;

@Entity
@Table(name = "primary_keys_table")
public class PrimaryKeysTable {

    @TableGenerator(
            name = "gen_table",
            table = "primary_keys_table_generator",
            pkColumnName = "pk",
            valueColumnName = "value",
            pkColumnValue = "default")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen_table")
    long id;

}
