package com.example.herrdone.DTO.Response;

import java.time.LocalDateTime;

public record PageRes(
        String member_ip,
        LocalDateTime visit_at
) {

}
