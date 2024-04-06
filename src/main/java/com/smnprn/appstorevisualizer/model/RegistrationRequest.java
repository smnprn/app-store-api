package com.smnprn.appstorevisualizer.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

public record RegistrationRequest(String firstName, String lastName, String email, String password) {}
