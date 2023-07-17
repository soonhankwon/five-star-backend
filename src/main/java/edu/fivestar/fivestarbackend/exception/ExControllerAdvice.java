package edu.fivestar.fivestarbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorResult illegalExHandle(IllegalArgumentException e) {
        return new ErrorResult("BAD", e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    public ErrorResult sessionExHandle(HttpSessionRequiredException e) {
        return new ErrorResult("INVALID SESSION", e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResult exHandle(Exception e) {
        return new ErrorResult("EX", "내부 오류");
    }
}
