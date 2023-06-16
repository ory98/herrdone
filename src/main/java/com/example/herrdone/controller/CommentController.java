package com.example.herrdone.controller;

import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.CommentRepository;
import com.example.herrdone.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {

//    private final CommentService commentService;

    private final CommentRepository commentRepository;

    @GetMapping("/all")
    public Object getAllComments(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        try {
            return new CommonResponse<>(HttpStatus.OK , "OK" , commentRepository.findAll());
        } catch (Exception e) {
            return ErrorCode.DB_CONNECTION_REFUSED;
        }
    }
}

