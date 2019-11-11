package com.spb.StrangersPlayBackend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccountDto {

    @NotNull
    private String username;

    @NotNull
    private String password;
    private boolean active;

    @NotNull
    private String email;
    private String firstName;
    private String lastName;
}
