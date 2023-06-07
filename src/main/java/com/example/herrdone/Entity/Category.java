package com.example.herrdone.Entity;

import com.example.herrdone.DTO.Response.CategoryRes;
import com.example.herrdone.util.AuditingEntityId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category extends AuditingEntityId {

    @Column(name = "category_name" , nullable = false)
    private String category_name;

    @Override
    public String toString(){
        return String.format("Category(id=%d, category_name=%s)", this.getId(), this.category_name);
    }

    public CategoryRes toResDto(){
        return new CategoryRes(this.getId(), this.category_name);
    }

}
