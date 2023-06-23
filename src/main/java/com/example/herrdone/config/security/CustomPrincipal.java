package com.example.herrdone.config.security;

import com.example.herrdone.entity.Member;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Slf4j
public class CustomPrincipal implements UserDetails {

    @Getter
    private Member member;

    public CustomPrincipal(Member member){
        this.member = member;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("Role 검증");

        ArrayList<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE : " + CustomPrincipal.this.getMember().getMember_type();
            }
        });

        return collection;
    }

    public Member.MemberType getMemberType(){
        return this.member.getMember_type();
    }

    @Override
    public String getPassword() {
        return this.member.getPassword();
    }

    @Override
    public String getUsername() {
        return this.member.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
