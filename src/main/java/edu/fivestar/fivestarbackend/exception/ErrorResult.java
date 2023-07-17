package edu.fivestar.fivestarbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public final class ErrorResult {

    private final String code;
    private final String message;
}
