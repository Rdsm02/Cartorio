package com.rodrigo.cartorio.exceptions;

public class CertidaoAPIException extends Exception {

    public CertidaoAPIException() {
    }

    public CertidaoAPIException(String message) {
        super(message);
    }

    public CertidaoAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public CertidaoAPIException(Throwable cause) {
        super(cause);
    }

    public CertidaoAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
