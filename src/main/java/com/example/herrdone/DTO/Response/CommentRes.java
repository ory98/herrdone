package com.example.herrdone.DTO.Response;

import com.example.herrdone.Entity.Member;
import com.example.herrdone.Entity.Post;

public record CommentRes(
        long id,
        MemberRes member,
        PostRes post,
        String comment
) { }
