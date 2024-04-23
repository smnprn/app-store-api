package com.smnprn.appstoreapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="developers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Developer {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    @Column(name = "developer_name")
    private String name;
    @Column(name = "developer_url")
    private String url;
    @Column(name = "developer_website")
    private String website;
}