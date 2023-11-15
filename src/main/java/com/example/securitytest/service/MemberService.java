package com.example.securitytest.service;

import com.example.securitytest.entity.member;
import com.example.securitytest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public void signup(member member){

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRole("user");
        memberRepository.save(member);
    }

    public Optional<member> findByMember_id(String memberId){
        return memberRepository.findByMemberId(memberId);
    }

/*    @Override
    public member loadUserByUsername(String member_id) throws UsernameNotFoundException {

        return memberRepository.findByMemberId(member_id).orElse(null);
    }*/

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        Optional<member> byMemberId = memberRepository.findByMemberId(memberId);

        member newMember = byMemberId.orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 ID입니다."));

        return User.builder()
                .username(newMember.getMemberId())
                .password(newMember.getPassword())
                .roles(newMember.getRole())
                .build();
    }
}
