package com.example.herrdone.DTO.Request;

import com.example.herrdone.Entity.Comment;
import com.example.herrdone.Entity.Member;
import com.example.herrdone.Entity.Post;

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
