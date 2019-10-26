package com.spb.StrangersPlayBackend.controller;

import com.spb.StrangersPlayBackend.dto.CategoryDto;
import com.spb.StrangersPlayBackend.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping
public class CategoryController {

    @GetMapping("/category")
    public List<CategoryDto> getListOfCategory() {
        return Arrays.stream(Category.values())
                .map(CategoryDto::new)
                .collect(toList());
    }
}
