package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Category;
import com.example.herrdone.entity.Member;
import com.example.herrdone.entity.Post;

import java.time.LocalDateTime;

public record PostSaveReq(

        Long category_id,
        String thumbnail,
        int hti_count,
        int pinned,
        String title,
        String content,
        int like_count,
        boolean open_status,
        boolean comment_status,
        boolean like_status,
        String endpoint,
        LocalDateTime display_at

) {

    public Post toEntity(Member member, Category category) {
        return Post.builder()
                .member(member)
                .category(category)
                .thumbnail(thumbnail)
                .pinned(pinned)
                .title(title)
                .content(content)
                .open_status(open_status)
                .like_status(like_status)
                .comment_status(comment_status)
                .endpoint(endpoint)
                .display_dt(display_at)
                .build();
    }
}

