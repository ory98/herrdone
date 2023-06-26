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

    @Column(name = "categoryname" , nullable = false, unique = true)
    private String categoryname;


    public CategoryRes toResDto(){
        return new CategoryRes(this.getId(), this.categoryname);
    }

    public Category (String categoryname) {
        this.categoryname = categoryname;
    }

    public void updateCategory (String categoryname){
        this.categoryname = categoryname;
    }

}
