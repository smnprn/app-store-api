package com.smnprn.appstorevisualizer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "apps")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class App {
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
        private String app_id;
        @Column(name = "app_name")
        private String name;
        @Column(name = "appstore_url")
        private String url;
        private String genre;
        private String contentRating;
        private Long size;
        @Column(name = "required_ios_version")
        private String ios_version;
        private Float price;
        private String currency;
        private Byte free;
        @Column(name = "developer_id")
        private Long developer_id;
        @Column(name = "avg_user_rating")
        private Double user_rating;
        private Integer reviews;
}
