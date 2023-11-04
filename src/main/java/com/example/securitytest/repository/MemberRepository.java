package com.example.securitytest.repository;

import com.example.securitytest.entity.member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<member, Long> {
        Optional<member> findByMember_id(String member_id);
}