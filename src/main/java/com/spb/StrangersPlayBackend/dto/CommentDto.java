package com.spb.StrangersPlayBackend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CommentDto {
    @NotNull
    private String authorUsername;
    @NotNull
    private String description;
}
