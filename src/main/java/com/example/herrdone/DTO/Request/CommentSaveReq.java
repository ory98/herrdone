package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Comment;
import com.example.herrdone.entity.Member;
import com.example.herrdone.entity.Post;

public record CommentSaveReq(
        Long post_id,
        String comment
) {
    public Comment toEntity(Member member, Post post){
        return Comment.builder()
                .member(member)
                .post(post)
                .comment(comment)
                .build();
    }
}
