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

    @Column(name = "explain_category", nullable = true)
    private String explain_category;


    public CategoryRes toResDto(){
        return new CategoryRes(this.getId(), this.categoryname, this.explain_category);
    }

    public Category (String categoryname, String explain_category) {
        this.categoryname = categoryname;
        this.explain_category = explain_category;
    }

    public void updateCategory (String categoryname, String explain_category){
        this.categoryname = categoryname;
        this.explain_category = explain_category;
    }

}
