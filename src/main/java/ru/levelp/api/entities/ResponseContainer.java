package ru.levelp.api.entities;

import com.google.gson.annotations.Expose;

/**
 * Created by Tanya on 09.12.2016.
 */
public class ResponseContainer<T> {
    @Expose
    private String requestId;
    @Expose
    private int code;
    @Expose
    private T payload;

    public ResponseContainer(T payload) {
        this.payload = payload;
    }

    public ResponseContainer(int code, T payload) {
        this.code = code;
        this.payload = payload;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
