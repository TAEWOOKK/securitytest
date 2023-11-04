package com.example.securitytest.service;

import com.example.securitytest.entity.member;
import com.example.securitytest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public member findByMember_id(String member_id){
        return memberRepository.findByMember_id(member_id).orElse(null);
    }

    @Override
    public Member loadUserByUsername(String member_id) throws UsernameNotFoundException {

        return memberRepository.findByMember_id(member_id).orElse(null);
    }
}
