package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Comment;
import com.example.herrdone.entity.Member;
import com.example.herrdone.entity.Post;

public record CommentSaveReq(
        Long member_id,
        Long post_id,
        String comment
) {
    public Comment toEntity(Member member, Post post){
        Comment commentEntity = new Comment();
        commentEntity.setComment(comment);
        commentEntity.setMember(member);
        commentEntity.setPost(post);
        return commentEntity;
    }
}
