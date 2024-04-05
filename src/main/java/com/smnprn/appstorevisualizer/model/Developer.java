package com.smnprn.appstorevisualizer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name="developers")
public class Developer {
    @Id
    private long id ;
    private String developer_name;
    private String developer_url;
    private String developer_website;

    public Developer() {}

    public Developer(long id, String developer_name, String developer_url, String developer_website) {
        this.id=id;
        this.developer_name=developer_name;
        this.developer_url=developer_url;
        this.developer_website=developer_website;
    }
}