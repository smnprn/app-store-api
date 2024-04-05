package com.smnprn.appstorevisualizer.repository;

import com.smnprn.appstorevisualizer.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopersRepository extends JpaRepository<Developer, Long> {}