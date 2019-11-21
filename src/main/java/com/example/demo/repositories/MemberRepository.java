package com.example.demo.repositories;

import com.example.demo.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findByEmail(String email);
}