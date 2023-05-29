package com.example.herrdone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "page")
@Getter
@Setter
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String member_ip;

    @Column(name = "count" , nullable = false)
    private int count;

    @Column(name = "create_at" , nullable = false)
    @CreatedDate
    private LocalDateTime create_at;
}
