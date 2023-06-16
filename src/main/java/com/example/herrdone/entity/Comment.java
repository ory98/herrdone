package com.example.herrdone.entity;

import com.example.herrdone.util.AuditingEntityDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")
@Getter
@ToString(exclude = {"member", "post"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends AuditingEntityDate {
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "comment" , nullable = false)
    private String comment;

    @Builder
    public Comment (Member member, Post post, String comment){
        this.member = member;
        this.post = post;
        this.comment = comment;
    }
    public void update (String comment){
        this.comment = comment;
    }

}

