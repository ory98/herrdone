package com.example.herrdone.service;

import com.example.herrdone.Entity.Member;
import com.example.herrdone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> userList() {
        // Pageable
        return memberRepository.findAll();
    }

}
