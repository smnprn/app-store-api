package com.smnprn.appstorevisualizer.service;

import com.smnprn.appstorevisualizer.model.Developer;
import com.smnprn.appstorevisualizer.repository.DevelopersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}