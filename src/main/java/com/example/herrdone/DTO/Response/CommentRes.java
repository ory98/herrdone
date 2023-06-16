package com.example.herrdone.DTO.Response;

public record CommentRes(
        long id,
        MemberRes member,
        PostRes post,
        String comment
) { }
