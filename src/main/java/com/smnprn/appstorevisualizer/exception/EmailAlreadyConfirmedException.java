package com.smnprn.appstorevisualizer.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmailAlreadyConfirmedException extends RuntimeException {
    public EmailAlreadyConfirmedException(String message) {
        super(message);
    }

    public EmailAlreadyConfirmedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyConfirmedException(Throwable cause) {
        super(cause);
    }
}
