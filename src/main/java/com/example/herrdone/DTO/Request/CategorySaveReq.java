package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Category;

public record CategorySaveReq(
        String category_name
) {
    public Category toEntity(){
        Category category = new Category();
        category.setCategory_name(category_name);
        return category;
    }
}
