package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Category;

public record CategorySaveReq(
        String categoryname,
        String explain_category
) {
    public Category toEntity(){
        return new Category(categoryname, explain_category);
    }
}
