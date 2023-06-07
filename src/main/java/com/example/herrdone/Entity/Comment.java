package com.example.herrdone.Entity;

import com.example.herrdone.util.AuditingEntityDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Getter
@Setter
public class Comment extends AuditingEntityDate {
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post.class)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "comment" , nullable = false)
    private String comment;

    @Override
    public String toString(){
        return String.format("Comment(id=%d, member=%s, post=%s, comment=%s)", this.getId(),this.member, this.post, this.comment);
    }

}

