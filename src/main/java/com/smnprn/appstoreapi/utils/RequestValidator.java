package com.smnprn.appstoreapi.utils;

import com.smnprn.appstoreapi.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class RequestValidator implements Predicate<RegistrationRequest> {
    private final EmailValidator emailValidator;

    @Override
    public boolean test(RegistrationRequest request) {
        return Stream.of(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.password()
        ).allMatch(Objects::nonNull) && emailValidator.test(request.email());
    }
}
