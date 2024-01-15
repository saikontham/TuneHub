package com.tunehub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_details",uniqueConstraints = {
        @UniqueConstraint(name="user_email_UNIQUE",columnNames = "email_id"),
        @UniqueConstraint(name = "user_name_UNIQUE",columnNames = "user_name")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name",
            nullable = false,
            columnDefinition = "TEXT")

    private String userName;

    @Column(name = "email_id",
            nullable = false)

    private String email;

    @Column(name = "user_password",
            nullable = false,
    length = 20)

    private String password;

    @Column(name = "user_gender",
            nullable = false,
            columnDefinition = "TEXT")

    private String gender;

    @Column(name = "user_role",
            nullable = false,
            columnDefinition = "TEXT")

    private String role;

    @Column(name = "user_address",
            nullable = false
            )

    private String address;

    private boolean isPremium;

}
