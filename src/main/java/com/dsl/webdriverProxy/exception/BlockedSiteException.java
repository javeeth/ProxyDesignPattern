package com.dsl.webdriverProxy.exception;

public class BlockedSiteException extends RuntimeException {
    public BlockedSiteException(String url) {
        super(String.format("%s is Blocked", url));
    }
}
