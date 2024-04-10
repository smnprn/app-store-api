package com.smnprn.appstorevisualizer.service;

import com.smnprn.appstorevisualizer.model.App;
import com.smnprn.appstorevisualizer.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    private final AppRepository appRepository;

    @Autowired
    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public List<App> getApps(
            Long id,
            String app_id,
            String name,
            String url,
            String genre,
            String contentRating,
            Long size,
            String ios_version,
            Float price,
            String currency,
            Byte free,
            Long developer_id,
            Double user_rating,
            Integer reviews
    ) {
        App app = new App();

        app.setId(id);
        app.setApp_id(app_id);
        app.setName(name);
        app.setUrl(url);
        app.setGenre(genre);
        app.setContentRating(contentRating);
        app.setSize(size);
        app.setIos_version(ios_version);
        app.setPrice(price);
        app.setCurrency(currency);
        app.setFree(free);
        app.setUser_rating(user_rating);
        app.setReviews(reviews);
        app.setDeveloper_id(developer_id);
        app.setUser_rating(user_rating);
        app.setReviews(reviews);

        return appRepository.findAll(Example.of(app));
    }
}
