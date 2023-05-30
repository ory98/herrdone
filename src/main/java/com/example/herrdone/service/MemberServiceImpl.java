package com.example.herrdone.service;

import com.example.herrdone.Entity.Member;
import com.example.herrdone.Entity.Page;
import com.example.herrdone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public List<Member> userList() {
        // Pageable
        return memberRepository.findAll();
    }
}
