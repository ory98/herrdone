package com.example.herrdone.controller;

import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.PostRepository;
import com.example.herrdone.service.PostService;
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
@RequestMapping("/post")
public class PostController {

//    private final PostService postService;

    private final PostRepository postRepository;

    @GetMapping ("/all")
    public Object getAllPosts(@PageableDefault(page = 0 , size = 10) Pageable pageable) {
        try {
            return new CommonResponse(HttpStatus.OK, "OK" , postRepository.findAll());
        } catch (Exception e) {
            return ErrorCode.DB_CONNECTION_REFUSED;
        }
    }

}
