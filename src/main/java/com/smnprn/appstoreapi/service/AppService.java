package com.smnprn.appstoreapi.service;

import com.smnprn.appstoreapi.model.App;
import com.smnprn.appstoreapi.repository.AppRepository;
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

    public List<App> getApps(App app) {
        return appRepository.findAll(Example.of(app));
    }
}
