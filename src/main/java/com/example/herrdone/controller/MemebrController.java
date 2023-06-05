package com.example.herrdone.controller;

import com.example.herrdone.Entity.Member;
import com.example.herrdone.repository.MemberRepository;
import com.example.herrdone.service.MemberService;
import com.example.herrdone.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemebrController {

    private final MemberService memberService;

    public MemebrController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Autowired
    public MemberRepository memberRepository;
//    @GetMapping("/user")
//    public CommonResponse findAllById(final Pageable pageable) {
//        // Pageable
//        CommonResponse result = new CommonResponse();
//
//        try {
//            Page<Member> members = MemberRepository.findAllById(pageable);
//            result.setData(memberService.getMembers());
//        } catch (Exception e){
//
//        }
//
//        return result;
//    }

    @GetMapping("/user")
    public String memberList(Model model, @RequestParam(value = "page" ,defaultValue = "1") int page) {
        Page<Member> paging = (Page<Member>) this.memberService.getMembers(page);
        model.addAttribute("paging", paging);

        return "memberList";
    }



}
