package com.example.herrdone.service;

import com.example.herrdone.DTO.Request.CategorySaveReq;
import com.example.herrdone.DTO.Response.CategoryRes;
import com.example.herrdone.entity.Category;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public CategoryRes saveCategory (CategorySaveReq categorySaveReq){
        if(categoryRepository.existsByCategoryname(categorySaveReq.categoryname())){
            throw new BusinessException(ErrorCode.DUPLICATED_DATA);
        }

        return categoryRepository
                .save(categorySaveReq.toEntity())
                .toResDto();
    }

    @Transactional
    public CategoryRes updateCategory (CategorySaveReq categorySaveReq){
        Category category = categoryRepository.findByCategoryname(categorySaveReq.categoryname());

        if(category == null){
            throw new BusinessException(ErrorCode.ENTITY_NOT_FOUND);
        }

        category.updateCategory(
                categorySaveReq.categoryname(),
                categorySaveReq.explain_category()
        );

        return categoryRepository.save(category).toResDto();
    }

    @Transactional
    public void deleteCategory(CategorySaveReq categorySaveReq) { categoryRepository.deleteByCategoryname(categorySaveReq.categoryname()); }
}
