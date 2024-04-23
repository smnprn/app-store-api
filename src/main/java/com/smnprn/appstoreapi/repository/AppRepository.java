package com.smnprn.appstoreapi.repository;

import com.smnprn.appstoreapi.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {}
