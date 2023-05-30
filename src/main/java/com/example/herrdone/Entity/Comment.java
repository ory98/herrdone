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
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member_id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post_id;

    @Column(name = "comment" , nullable = false)
    private String comment;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime created_at;

    @Column(name = "modified_at", nullable = true)
    @LastModifiedDate
    private LocalDateTime modified_at;


}

