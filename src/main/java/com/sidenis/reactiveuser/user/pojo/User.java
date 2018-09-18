package com.sidenis.reactiveuser.user.pojo;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;

/**
 * Created by dell on 10.09.18.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("user")
public class User {

    @PrimaryKey
    private Long id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("date_of_birth")
    private LocalDate dateOfBirth;

}
