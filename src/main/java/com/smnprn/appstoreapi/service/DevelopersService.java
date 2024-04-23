package com.smnprn.appstoreapi.service;

import com.smnprn.appstoreapi.model.Developer;
import com.smnprn.appstoreapi.repository.DevelopersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DevelopersService {
    private final DevelopersRepository developersRepository;

    @Autowired
    public DevelopersService(DevelopersRepository developersRepository) {
        this.developersRepository = developersRepository;
    }

    public List<Developer> getDeveloperById(Long id) {
        return developersRepository.findAllById(Collections.singleton(id));
    }

    public List<Developer> getDevelopers(Long id, String name, String url, String website) {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setName(name);
        developer.setUrl(url);
        developer.setWebsite(website);

        return developersRepository.findAll(Example.of(developer));
    }
}