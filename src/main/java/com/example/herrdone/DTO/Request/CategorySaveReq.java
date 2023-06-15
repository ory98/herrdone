package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Category;

public record CategorySaveReq(
        String category_name
) {
    public Category toEntity(){
        return new Category(category_name);
    }
}
