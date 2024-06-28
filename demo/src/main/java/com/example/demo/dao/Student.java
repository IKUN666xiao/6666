package com.example.demo.dao;

import com.example.demo.converter.GenderConverter;
import com.example.demo.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="age")
    private int age;

    @Column(name="gender")
    @Convert(converter=GenderConverter.class)
    private Gender gender;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}