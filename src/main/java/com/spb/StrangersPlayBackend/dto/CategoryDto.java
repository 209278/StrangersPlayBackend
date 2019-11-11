package com.spb.StrangersPlayBackend.dto;

import com.spb.StrangersPlayBackend.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private String type;
    private String name;

    public CategoryDto(Category category) {
        this.name = category.getCategoryName();
        this.type = category.name();
    }
}
