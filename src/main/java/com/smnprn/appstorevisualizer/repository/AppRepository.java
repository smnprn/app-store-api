package com.smnprn.appstorevisualizer.repository;

import com.smnprn.appstorevisualizer.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {}
