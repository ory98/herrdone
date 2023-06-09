package com.example.herrdone.DTO.Request;

import com.example.herrdone.Entity.Page;

import java.time.LocalDateTime;

public record PageSaveReq(

        String member_ip,
        LocalDateTime visited_at

) {

    public Page toEntity() {
        Page page = new Page();
        page.setMember_ip(member_ip);
        page.setVisited_at(visited_at);

        return page;
    }
}
