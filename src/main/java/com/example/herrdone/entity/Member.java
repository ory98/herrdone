package com.example.herrdone.entity;


import com.example.herrdone.DTO.Response.MemberRes;
import com.example.herrdone.util.AuditingEntityDate;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "member")
@Getter
@ToString(exclude = {"password"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends AuditingEntityDate {

    @Column(name = "membername", nullable = false)
    private String membername;

    @Column(name = "password", nullable = false)
    private String password; // 추후 security에서 암호화 후 저장

    @Column(name = "email", nullable = false, unique = true)
    private String email; // 유저의 회원 아이디로 사용

    @Enumerated(value = EnumType.STRING)
    private MemberType member_type; // 0 - USER, 1 - ADMIN

    @Enumerated(value = EnumType.STRING)
    private MemberGender gender; // 0 - MALE, 1 - FEMALE, 2 - UNKNOWN

    public MemberRes toResDto(){
        return new MemberRes(this.getId(), this.email, this.membername, this.member_type.getType(), this.gender.getGender());
    }

    @Builder
    public Member (String membername, String password, String email, int member_type, int gender){
        this.membername = membername;
        this.password = password;
        this.email = email;
        this.member_type = member_type == 0 ? MemberType.USER : MemberType.ADMIN;
        this.gender = gender == 0 ? MemberGender.MALE : gender == 1 ? MemberGender.FEMALE : MemberGender.UNKNOWN;
    }

    public enum MemberType {
        ADMIN("admin"),
        USER("user");

        @Getter
        private String type;

        MemberType(String type){
            this.type = type;
        }
    }

    public enum MemberGender {
        MALE("male"),
        FEMALE("female"),
        UNKNOWN("unknown");

        @Getter
        private String gender;

        MemberGender(String gender){
            this.gender = gender;
        }
    }

    public void updateMember (String membername, String password, int gender, int member_type){
        this.membername = membername;
        this.password = password;
        this.member_type = member_type == 0 ? MemberType.USER : MemberType.ADMIN;
        this.gender = gender == 0 ? MemberGender.MALE : gender == 1 ? MemberGender.FEMALE : MemberGender.UNKNOWN;
    }

}
