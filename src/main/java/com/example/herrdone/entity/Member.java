package com.example.herrdone.entity;


import com.example.herrdone.DTO.Response.MemberRes;
import com.example.herrdone.util.AuditingEntityDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "member")
@Getter
@Setter
public class Member extends AuditingEntityDate {

    @Column(name = "membername", nullable = false, unique = true)
    private String membername;

    @Column(name = "password", nullable = false)
    private String password; // 추후 security에서 암호화 후 저장

    @Column(name = "email", nullable = false)
    private String email; // 유저의 회원 아이디로 사용

    @Column(name = "member_type", nullable = false)
    private int member_type; // 0 - USER, 1 - ADMIN

    @Column(name = "gender", nullable = false)
    private int gender; // 0 - MALE, 1 - FEMALE, 2 - UNKNOWN

    @Override
    public String toString(){
        return String.format("Member(id=%d, membername=%s, password=%s, email=%s, member_type=%d", this.getId(), this.membername, this.password, this.email, this.member_type);
    }

    public MemberRes toResDto(){
        return new MemberRes(this.getId(), this.email, this.membername, this.member_type == 1 ? "admin" : "user", this.gender == 0 ? "male" : this.gender == 1 ? "female" : "unknown");
    }

}
