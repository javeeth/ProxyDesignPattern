package com.dsl.dbProxy.exception;

public class InvalidEnvException extends RuntimeException {
    public InvalidEnvException(String env) {
        super(String.format("Cannot Access %s Environment.", env));
    }
}
