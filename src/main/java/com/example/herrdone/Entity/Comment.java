package com.example.herrdone.Entity;

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long comment_id;

    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "id" , nullable = false)
    private Member id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @Column(name = "post_id" , nullable = false)
    private Post post_id;

    @Column(name = "comment" , nullable = false)
    private String comment;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime created_at;

    @Column(name = "modified_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime modified_at;


}

