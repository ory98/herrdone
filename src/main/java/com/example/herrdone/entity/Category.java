package com.example.herrdone.entity;

import com.example.herrdone.DTO.Response.CategoryRes;
import com.example.herrdone.util.AuditingEntityId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends AuditingEntityId {

    @Column(name = "category_name" , nullable = false, unique = true)
    private String category_name;


    public CategoryRes toResDto(){
        return new CategoryRes(this.getId(), this.category_name);
    }

    public Category (String category_name) {
        this.category_name = category_name;
    }

    public void updateCategory (String category_name){
        this.category_name = category_name;
    }

}
