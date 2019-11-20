package com.spb.StrangersPlayBackend.dto;

import com.spb.StrangersPlayBackend.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.stream.Stream;

@Getter
@Setter
public class CategoryDto {
    private String type;
    private String name;
    private String image;

    public CategoryDto(Category category) throws IOException {
        this.name = category.getCategoryName();
        this.type = category.name();
        this.image = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(category.getFilename())));
    }

    public CategoryDto(String name, String type) {
        this.name = name;
        this.type = type;
        this.image = "error";
    }
}
