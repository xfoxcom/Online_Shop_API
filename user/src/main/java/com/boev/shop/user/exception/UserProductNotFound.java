package com.boev.shop.user.exception;

public class UserProductNotFound extends RuntimeException {

    public UserProductNotFound(String message) {
        super(message);
    }
}
