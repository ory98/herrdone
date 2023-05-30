package com.example.herrdone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    @Column(name = "thumbnail" )
    private String thumbnail;

    @Column(name = "hit_count" , nullable = false)
    private int hit_count;

    @Column(name = "pinned" , nullable = false)
    private int pinned;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "content" )
    private byte[] content;

    @Column(name = "like_count" )
    private int like_count;

    @Column(name = "open_status" )
    private boolean open_status;

    @Column(name = "comment_status")
    private boolean comment_status;

    @Column(name = "like_status" )
    private boolean like_status;

    @Column(name = "endpoint" , nullable = false)
    private String endpoint;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime created_at;

    @Column(name = "modified_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime modified_at;

}
