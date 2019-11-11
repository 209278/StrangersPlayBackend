package com.spb.StrangersPlayBackend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomResponse {

    private int httpCode;
    private String message;
}
