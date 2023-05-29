package com.example.herrdone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository {
    List<Void> userList();

}
