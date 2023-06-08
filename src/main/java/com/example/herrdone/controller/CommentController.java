package com.example.herrdone.controller;

import com.example.herrdone.repository.CommentRepository;
import com.example.herrdone.service.CommentService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

//    private final CommentService commentService;

    private final CommentRepository commentRepository;

    @GetMapping("/all")
    public CommonResponse getAllComments(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        CommonResponse result = null;
        try {
            result = new CommonResponse("200" , "OK" , commentRepository.findAll());
        } catch (Exception e) {
            result = new CommonResponse<>("503", "Database Connection Error" , null);
        }
        return result;
    }
}

