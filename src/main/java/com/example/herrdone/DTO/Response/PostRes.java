package com.example.herrdone.DTO.Response;

public record PostRes(
        long id,
        MemberRes member,
        CategoryRes category,
        String thumbnail,
        int hit_count,
        int pinned,
        String title,
        String content,
        int like_count,
        boolean open_status,
        boolean like_status,
        String endpoint
) {
}
