package com.example.herrdone.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final EntityManager em;

    @Override
    public List<Void> userList() {
        return em.createQuery("").getResultList();
    }
}
