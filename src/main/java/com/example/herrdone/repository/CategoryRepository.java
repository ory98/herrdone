package com.example.herrdone.repository;

import com.example.herrdone.entity.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
//    boolean existsByCategory_name(String categoryName);
    boolean existsByCategoryname(String category_name);
}
