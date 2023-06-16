package com.example.herrdone.DTO.Response;

public record MemberRes(
        long id,
        String email,
        String membername,
        String member_type,
        String gender
) { }
