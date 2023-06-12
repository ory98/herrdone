package com.example.herrdone.entity;

import com.example.herrdone.util.AuditingEntityDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
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
    private int hit_count;

    @Column(name = "pinned" , nullable = false)
    private int pinned;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "content" )
    @Lob
    private String content;

    @Column(name = "like_count" )
    private int like_count;

    @Column(name = "open_status" )
    private boolean open_status;

    @Column(name = "comment_status")
    private boolean comment_status;

    @Column(name = "like_status" )
    private boolean like_status;

    @Column(name = "endpoint" , nullable = false, unique = true)
    private String endpoint;

    @Column(name = "display_dt")
    private LocalDateTime display_dt;

}
