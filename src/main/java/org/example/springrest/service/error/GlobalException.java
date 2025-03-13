package org.example.springrest.service.error;

import org.example.springrest.domain.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = { IdInvalidException.class })
    public ResponseEntity<RestResponse<Object>> handleIdInvalidException(IdInvalidException e) {
        RestResponse<Object> res = new RestResponse<Object>();
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setMessage("Id invalid");
        res.setErrorMessage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
