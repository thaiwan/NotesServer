package ru.levelp.errors;

/**
 * Created by Tanya on 13.12.2016.
 */
public class RequestExecutionError extends Exception {
    public RequestExecutionError (String message) {
        super(message);
    }
}
