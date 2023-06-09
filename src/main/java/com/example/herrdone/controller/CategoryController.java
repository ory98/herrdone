package com.example.herrdone.controller;

import com.example.herrdone.repository.CategoryRepository;
import com.example.herrdone.service.CategoryService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Category")
public class CategoryController {

//    private final CategoryService categoryService;

    public final CategoryRepository categoryRepository;
    @GetMapping("/all")
    public CommonResponse getAllCategory(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        CommonResponse result = null;

        try {
            result = new CommonResponse<>("200" , "OK" , categoryRepository.findAll(pageable).map(category -> category.toResDto()));
        }
        catch (Exception e) {
            result = new CommonResponse<>("503", "Database Connection Error" , null);
        }

        return result;
    }
}
