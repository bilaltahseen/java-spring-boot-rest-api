package org.bilaltahseen.jobposting.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="role",nullable = false)
        private String role;

        @Column(name="first_name",nullable = false)
        private String firstName;

        @Column(name="last_name",nullable = false)
        private String lastName;

        @Column(name="email",nullable = false)
        private String email;

        @Column(name="password",nullable = false)
        private String password;
}
