package com.example.herrdone.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" , nullable = false)
    private long id;

    @Column(name = "membername", nullable = false)
    private String membername;

    @Column(name = "password", nullable = false)
    private String password; // 추후 security에서 암호화 후 저장

    @Column(name = "email")
    private String email;

    @Column(name = "member_type", nullable = false)
    private int member_type; // 0 - USER, 1 - ADMIN

    @Column(name = "gender")
    private int gender; // 0 - MALE, 1 - FEMALE

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime created_at;

    @Column(name = "modified_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime modified_at;
}
