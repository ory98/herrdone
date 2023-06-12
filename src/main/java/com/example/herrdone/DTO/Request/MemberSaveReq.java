package com.example.herrdone.DTO.Request;

import com.example.herrdone.entity.Member;

public record MemberSaveReq(
        String membername,
        String password,
        String email,
        int member_type,
        int gender
){

    public Member toEntity(){
        Member member = new Member();
        member.setMembername(membername);
        member.setPassword(password);
        member.setEmail(email);
        member.setMember_type(member_type);
        member.setGender(gender);
        return member;
    }
}

