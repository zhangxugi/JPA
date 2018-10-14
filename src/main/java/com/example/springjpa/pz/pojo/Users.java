package com.example.springjpa.pz.pojo;



import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name="users")
    public class Users {
            @Id
            @GeneratedValue(strategy= GenerationType.AUTO)
            private long id;
            @Column(nullable = false, unique = true)
            private String username;
            @Column(nullable = false)
            private String password;
            @Column(nullable = false)
            private int age;
        }