package com.example.herrdone.repository;

import com.example.herrdone.Entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PageRepository extends JpaRepository<Page, Long> {

}
