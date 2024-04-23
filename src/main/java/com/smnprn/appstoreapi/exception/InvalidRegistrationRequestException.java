package com.smnprn.appstoreapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidRegistrationRequestException extends RuntimeException {
    public InvalidRegistrationRequestException(String message) {
        super(message);
    }

    public InvalidRegistrationRequestException(Throwable cause) {
        super(cause);
    }

    public InvalidRegistrationRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
