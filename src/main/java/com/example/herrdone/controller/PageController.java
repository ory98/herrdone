package com.example.herrdone.controller;

import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.PageRepository;
import com.example.herrdone.service.PageService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/page")
public class PageController {

//    private final PageService pageService;

    public final PageRepository pageRepository;

    @GetMapping("/all")
    public Object getAllPage(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        try {
            return new CommonResponse<>(HttpStatus.OK, "OK" , pageRepository.findAll(pageable).map(page -> page.toResDto()));
        }
        catch (Exception e) {
            return ErrorCode.DB_CONNECTION_REFUSED;
        }
    }

}
