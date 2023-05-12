package com.babul.authservice.exception;

public class DokanException extends RuntimeException {
    private String clazz;
    private String method;
    private String message;

    public DokanException(String clazz, String method, String message) {
        super("class: ".concat(clazz)
                .concat(", method: ").concat(method)
                .concat(", message: ").concat(message));
    }
}
