package com.smnprn.appstoreapi.repository;

import com.smnprn.appstoreapi.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopersRepository extends JpaRepository<Developer, Long> {}