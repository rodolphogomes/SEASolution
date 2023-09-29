package com.rodolpho.SEASolution.exception;

import com.rodolpho.SEASolution.util.apiResponse;
import io.swagger.annotations.ApiResponse;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.lang.Boolean.FALSE;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<apiResponse> conflict(DataIntegrityViolationException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        apiResponse apiResponse = new apiResponse(message, FALSE);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }

    @ExceptionHandler(ConfigDataResourceNotFoundException.class)
    public ResponseEntity<apiResponse> resourceNotFoundExceptionHandler(ConfigDataResourceNotFoundException ex) {
        String message = ex.getMessage();
        apiResponse apiResponse = new apiResponse(message,false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

}
