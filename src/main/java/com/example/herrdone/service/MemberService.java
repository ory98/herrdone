package com.example.herrdone.service;

import com.example.herrdone.DTO.Request.MemberFindReq;
import com.example.herrdone.DTO.Request.MemberSaveReq;
import com.example.herrdone.DTO.Response.MemberRes;
import com.example.herrdone.entity.Member;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberRes findMember (MemberFindReq memberFindReq, String email, String memberType){
        if(memberFindReq.type().equals("search") && memberType.equals(Member.MemberType.ADMIN.getType())){
            return memberRepository
                    .findById(memberFindReq.id())
                    .orElseThrow(() -> new BusinessException(ErrorCode.CANNOT_FIND_USER))
                    .toResDto();
        } else if(!memberFindReq.type().equals("search")){
            return memberRepository
                    .findByEmail(email)
                    .toResDto();
        } else throw new BusinessException(ErrorCode.NO_PARAM);
    }

    @Transactional
    public MemberRes saveMember (MemberSaveReq memberSaveReq) {
        if(memberRepository.existsMemberByEmail(memberSaveReq.email())){
            throw new BusinessException(ErrorCode.DUPLICATED_DATA);
        }
        return memberRepository.save(
                memberSaveReq.toEntity(
                        passwordEncoder.encode(
                                memberSaveReq.password()
                        )
                )
        ).toResDto();
    }

    @Transactional
    public MemberRes updateMember(MemberSaveReq memberSaveReq){
        Member member = memberRepository.findByEmail(memberSaveReq.email());
        if(member == null){
            throw new BusinessException(ErrorCode.CANNOT_FIND_USER);
        }
        member.updateMember(
                memberSaveReq.membername(),
                memberSaveReq.password(),
                memberSaveReq.gender(),
                memberSaveReq.member_type()
        );
        return memberRepository.save(member).toResDto();
    }

    public void deleteMember(long id){
        memberRepository.deleteById(id);
    }
}
