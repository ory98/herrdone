package com.example.herrdone.entity;

import com.example.herrdone.DTO.Response.CategoryRes;
import com.example.herrdone.DTO.Response.PostRes;
import com.example.herrdone.util.AuditingEntityDate;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString(exclude = {"member", "category"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends AuditingEntityDate {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member.class)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "thumbnail" )
    private String thumbnail;

    @Column(name = "hit_count" , nullable = false)
    private int hit_count; // 조회수

    @Column(name = "pinned" , nullable = false)
    private int pinned; // 0이라면 일반 게시물, 1 이상이라면 고정게시물, int인 이유는 몇번째 순서로 올지 정하기 위함

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "content" )
    @Lob
    private String content;

    @Column(name = "like_count" )
    private int like_count; // 좋아요 갯수

    @Column(name = "open_status" )
    private boolean open_status; // 포스팅 공개 여부

    @Column(name = "like_status" )
    private boolean like_status; // 좋아요 공개 및 허용 여부

    @Column(name = "comment_status")
    private boolean comment_status; // 댓글 허용 여부

    @Column(name = "endpoint" , nullable = false, unique = true)
    private String endpoint;

    @Column(name = "display_dt")
    private LocalDateTime display_dt;

    public PostRes toResDto(){
        return new PostRes(
                this.getId(),
                this.member.toResDto(),
                this.category.toResDto(),
                this.thumbnail,
                this.hit_count,
                this.pinned,
                this.title,
                this.content,
                this.like_count,
                this.open_status,
                this.comment_status,
                this.like_status,
                this.endpoint,
                this.display_dt
        );
    }

    @Builder
    public Post(
            Member member,
            Category category,
            String thumbnail,
            int pinned,
            String title,
            String content,
            boolean open_status,
            boolean like_status,
            boolean comment_status,
            String endpoint,
            LocalDateTime display_dt
    ) {
        this.member = member;
        this.category = category;
        this.thumbnail = thumbnail;
        this.hit_count = 0;
        this.pinned = pinned;
        this.title = title;
        this.content = content;
        this.like_count = 0;
        this.open_status = open_status;
        this.like_status = like_status;
        this.comment_status = comment_status;
        this.endpoint = endpoint;
        this.display_dt = display_dt;
    }

}
