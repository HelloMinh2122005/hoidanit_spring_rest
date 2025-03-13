package org.example.springrest.domain.response;

import lombok.Data;

@Data
public class RestResponse<T> { // data phải quy định kiểu trả ra => vì ta có thể không biết kiểu trả ra
    private int status;
    private String errorMessage;

    private Object message;
    private T data;
}
