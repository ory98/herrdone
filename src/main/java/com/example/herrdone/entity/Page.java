package com.example.herrdone.entity;

import com.example.herrdone.DTO.Response.PageRes;
import com.example.herrdone.util.AuditingEntityId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "page")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Page extends AuditingEntityId {
    @Column(name = "member_ip")
    private String member_ip;

    @Column(name = "visited_at" , nullable = false)
    @CreatedDate
    private LocalDateTime visited_at;

    public PageRes toResDto() {
        return new PageRes(this.getMember_ip(),this.visited_at);
    }

    public Page (String member_ip) {
        this.member_ip = member_ip;
    }

}
