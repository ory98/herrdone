package com.example.herrdone.config;

import com.example.herrdone.DTO.Request.MemberSaveReq;
import com.example.herrdone.config.security.JwtManager;
import com.example.herrdone.entity.Member;
import com.example.herrdone.repository.MemberRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class CreateDummyData {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    // 더미데이터가 필요한 경우에만
    @EventListener(ApplicationReadyEvent.class)
    public void createDummyData(){
        System.out.println(passwordEncoder.encode("123123"));
//        List<Member> memberList = new ArrayList<>();
//        int count = 0;
//        while (count < 100){
//            memberList.add(generateMember());
//            count++;
//        }
//        memberRepository.saveAll(memberList);
    }
    // 더미데이터가 필요한 경우에만

    private Member generateMember () {
        Faker faker = new Faker();
        Random random = new Random();
        MemberSaveReq memberSaveReq = new MemberSaveReq(faker.artist().name(), faker.business().creditCardNumber(), faker.internet().safeEmailAddress(), random.nextInt(2), random.nextInt(2));
        return memberSaveReq.toEntity(passwordEncoder.encode(faker.business().creditCardNumber()));
    }
}
