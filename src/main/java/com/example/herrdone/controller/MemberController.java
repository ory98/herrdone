package com.example.herrdone.controller;

import com.example.herrdone.DTO.Request.MemberSaveReq;
import com.example.herrdone.entity.Member;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.exception.ErrorResponse;
import com.example.herrdone.repository.MemberRepository;
import com.example.herrdone.service.MemberService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    public final MemberRepository memberRepository;

    @GetMapping("/all")
    public Object getAllMembers(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        try {
            return new CommonResponse<>(HttpStatus.OK, "멤버 목록을 불러왔습니다.", memberRepository.findAll(pageable).map(member -> member.toResDto()));
        } catch (Exception e) {
            return ErrorCode.DB_CONNECTION_REFUSED;
        }
    }

//    @GetMapping
//    public Object getMember(){
//
//    }

    @PostMapping
    public Object postNewMember(@RequestBody MemberSaveReq memberSaveReq) {
        try {
            return new CommonResponse<>(HttpStatus.CREATED, "멤버 생성이 완료되었습니다.", memberService.saveMember(memberSaveReq));
        } catch (BusinessException e){
            return e.getErrorCode();
        }
    }

    @PutMapping
    public Object updateMember(@RequestBody MemberSaveReq memberSaveReq) {
        try {
            return new CommonResponse<>(HttpStatus.OK, "회원 정보 수정이 완료되었습니다.", memberService.updateMember(memberSaveReq));
        } catch (BusinessException e){
            return e.getErrorCode();
        }
    }



}
