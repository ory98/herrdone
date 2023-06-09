package com.example.herrdone.DTO.Request;

import com.example.herrdone.Entity.Category;
import com.example.herrdone.Entity.Member;
import com.example.herrdone.Entity.Post;

import java.time.LocalDateTime;

public record PostSaveReq(

        Long member_id,
        Long category_id,
        String thumbnail,
        int hti_count,
        int pinned,
        String title,
        String content,
        int like_count,
        boolean open_status,
        boolean like_status,
        String endpoint,
        LocalDateTime display_at

) {

    public Post toEntity(Member member, Category category) {
        Post post = new Post();
        post.setMember(member);
        post.setCategory(category);
        post.setThumbnail(thumbnail);
        post.setHit_count(hti_count);
        post.setPinned(pinned);
        post.setTitle(title);
        post.setContent(content);
        post.setLike_count(like_count);
        post.setOpen_status(open_status);
        post.setComment_status(post.isComment_status());
        post.setLike_status(like_status);
        post.setEndpoint(endpoint);
        post.setDisplay_dt(display_at);

        return post;
    }
}

