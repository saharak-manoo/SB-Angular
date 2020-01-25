package com.example.demo.controllers;

import com.example.demo.models.Member;
import com.example.demo.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import javax.validation.Valid;

@RestController
public class MemberController extends ApplicationController {
  @Autowired
  private MemberService memberService;

  @GetMapping("members")
  public List<Member> all() {
    System.out.println(">>>>>> dove");
    System.out.println(memberService.getAllMembers().size());
    System.out.println(memberService.getAllMembers().get(0).getFirstName());
    return memberService.getAllMembers();
  }

  @GetMapping("/members/{id}")
  public ResponseEntity<?> showMember(@PathVariable Long id) {
    return ResponseEntity.ok(memberService.findMemberById(id));
  }

  @PostMapping("/members")
  public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
    return ResponseEntity.ok(memberService.saveMember(member));
  }

  @PutMapping("/members/{id}")
  public ResponseEntity<Member> updateMember(@Valid @RequestBody Member member, @PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(memberService.updateMember(member, id));
  }

  @DeleteMapping("/members/{id}")
  public ResponseEntity<?> deleteMember(@PathVariable Long id) {
    Map<String, String> response = new HashMap<String, String>();
    if (memberService.deleteMember(id)) {
      response.put("status", "success");
      response.put("message", "member deleted successfully");
      return ResponseEntity.ok(response);
    } else {
      response.put("status", "error");
      response.put("message", "Something went wrong when delete the member");
      return ResponseEntity.status(500).body(response);
    }
  }
}