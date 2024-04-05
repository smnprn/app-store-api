package com.smnprn.appstorevisualizer.controller;

import com.smnprn.appstorevisualizer.model.Developer;
import com.smnprn.appstorevisualizer.service.DevelopersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v0.1/developers")
public class DevelopersController {
    private final DevelopersService developersService;

    @Autowired
    public DevelopersController(DevelopersService developersService) {
        this.developersService = developersService;
    }

    @GetMapping
    public List<Developer> developer(@RequestParam(value = "id") Long id) {
        return developersService.getDeveloperById(id);
    }
}