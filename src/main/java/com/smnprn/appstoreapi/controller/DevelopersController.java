package com.smnprn.appstoreapi.controller;

import com.smnprn.appstoreapi.model.Developer;
import com.smnprn.appstoreapi.service.DevelopersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Developer>> developer(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "url", required = false) String url,
            @RequestParam(value = "website", required = false) String website
    ) {
        List<Developer> developers = developersService.getDevelopers(id, name, url, website);

        if (!developers.isEmpty()) {
            return ResponseEntity.ok(developers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}