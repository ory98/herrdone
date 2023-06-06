package com.example.herrdone.controller;

import com.example.herrdone.repository.PostRepository;
import com.example.herrdone.service.PostService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

//    private final PostService postService;

    private final PostRepository postRepository;

    @GetMapping ("/post")
    public CommonResponse postList(@PageableDefault(page = 0 , size = 10) Pageable pageable) {
        CommonResponse result = null;

        try {
            result = new CommonResponse("200" , "OK" , postRepository.findAll());
        } catch (Exception e) {
            result = new CommonResponse<>("503", "Database Connection Error" , null);
        }
        return result;
    }

}
