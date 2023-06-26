package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Category;

public record CategorySaveReq(
        String categoryname
) {
    public Category toEntity(){
        return new Category(categoryname);
    }
}
