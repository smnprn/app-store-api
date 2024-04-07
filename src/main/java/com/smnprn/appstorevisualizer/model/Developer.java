package com.smnprn.appstorevisualizer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="developers")
public class Developer {
    @Id
    private long id ;
    private String developer_name;
    private String developer_url;
    private String developer_website;
}