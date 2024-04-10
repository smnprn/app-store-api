package com.smnprn.appstorevisualizer.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConfirmationEmailException extends RuntimeException {
    public ConfirmationEmailException(String message) {
        super(message);
    }

    public ConfirmationEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfirmationEmailException(Throwable cause) {
        super(cause);
    }
}
