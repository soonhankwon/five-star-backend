package edu.fivestar.fivestarbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class UserResignReqDto {

    private final String email;

    private final String name;

    private final String password;
}
