package com.example.antipolice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "anti_police_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    String username;

    String password;

    int age;

    public User() {
    }
}
