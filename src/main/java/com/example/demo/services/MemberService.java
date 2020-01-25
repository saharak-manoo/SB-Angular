package com.example.demo.services;

import com.example.demo.models.Member;
import com.example.demo.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("memberService")
public class MemberService {
  @Autowired
  private MemberRepository memberRepository;

  public Member findMemberByEmail(String email) {
    return memberRepository.findByEmail(email);
  }

  public Member findMemberById(Long id) {
    return memberRepository.findById(id).orElse(null);
  }

  public List<Member> getAllMembers() {
    return memberRepository.findAll();
  }

  public Member saveMember(Member member) {
    return memberRepository.save(member);
  }

  public Member updateMember(Member member, Long id) {
    Member updateMember = memberRepository.findById(id).orElse(null);
    if (updateMember != null) {
      updateMember.setFirstName(member.getFirstName());
      updateMember.setLastName(member.getLastName());
    }
    final Member myMember = memberRepository.save(updateMember);
    return updateMember;
  }

  public Boolean deleteMember(Long id) {
    Member delMember = memberRepository.findById(id).orElse(null);
    if (delMember != null) {
      memberRepository.delete(delMember);
      return true;
    }
    return false;
  }
}