package com.smnprn.appstorevisualizer.service;

import com.smnprn.appstorevisualizer.model.Developer;
import com.smnprn.appstorevisualizer.repository.DevelopersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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