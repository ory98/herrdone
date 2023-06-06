package com.example.herrdone.controller;

import com.example.herrdone.repository.MemberRepository;
import com.example.herrdone.service.MemberService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class MemberController {

//    private final MemberService memberService;

    public final MemberRepository memberRepository;
    @GetMapping("/member")
    public CommonResponse memberList(@PageableDefault(page = 0, size = 10) Pageable pageable) {

        CommonResponse result = null;

        try {
            result = new CommonResponse<>("200" , "OK" , memberRepository.findAll(pageable));
        }
        catch (Exception e) {
            result = new CommonResponse<>("503", "Database Connection Error" , null);
        }

        return result;

    }



}
