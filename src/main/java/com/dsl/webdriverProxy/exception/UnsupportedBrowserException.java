package com.dsl.webdriverProxy.exception;

public class UnsupportedBrowserException extends RuntimeException {
    public UnsupportedBrowserException(String browserName) {
        super(String.format("Browser %s is not supported", browserName));
    }
}
