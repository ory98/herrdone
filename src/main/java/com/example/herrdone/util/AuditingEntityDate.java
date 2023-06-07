package com.example.herrdone.util;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class AuditingEntityDate extends AuditingEntityId {
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    protected LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modified_at;

}
