package com.example.herrdone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "page")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Page<M> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "member_ip")
    private String member_ip;

    @Column(name = "visited_at" , nullable = false)
    @CreatedDate
    private LocalDateTime visited_at;
}
