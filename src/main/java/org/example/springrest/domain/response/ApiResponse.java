package org.example.springrest.domain.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int status;
    private String error;
    private T payload;

    public ApiResponse(int status, String error, T payload) {
        this.status = status;
        this.error = error;
        this.payload = payload;
    }
}
