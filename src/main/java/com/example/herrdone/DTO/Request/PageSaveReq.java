package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Page;

import java.time.LocalDateTime;

public record PageSaveReq(
        String member_ip
) {

    public Page toEntity() {
        return new Page(member_ip);
    }
}
