package com.example.herrdone.service;

import com.example.herrdone.DTO.Request.CategorySaveReq;
import com.example.herrdone.DTO.Response.CategoryRes;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

}
