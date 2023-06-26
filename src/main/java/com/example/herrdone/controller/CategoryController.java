package com.example.herrdone.controller;

import com.example.herrdone.DTO.Request.CategorySaveReq;
import com.example.herrdone.config.security.annotation.NeedAdmin;
import com.example.herrdone.config.security.annotation.NeedLogin;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.CategoryRepository;
import com.example.herrdone.service.CategoryService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    public final CategoryRepository categoryRepository;
    @GetMapping("/all")
    public Object getAllCategory(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        try {
            return new CommonResponse<>(HttpStatus.OK, "OK", categoryRepository.findAll(pageable).map(category -> category.toResDto()));
        } catch (Exception e) {
            return ErrorCode.DB_CONNECTION_REFUSED;
        }
    }

    @PostMapping
    @NeedAdmin
    public Object postCategory(@RequestBody CategorySaveReq categorySaveReq){
        log.info(categorySaveReq.toString());
        try {
            return new CommonResponse<>(HttpStatus.CREATED, "Category Created", categoryService.saveCategory(categorySaveReq));
        } catch (BusinessException e){
            return e.getErrorCode();
        }
    }



}
