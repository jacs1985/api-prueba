package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "telefono")
@Entity
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate the ID
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "citycode")
    private String citycode;

    @Column(name = "contrycode")
    private String contrycode;

    // Getters y Setters
}
