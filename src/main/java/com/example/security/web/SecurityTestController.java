package com.example.security.web;

import com.example.security.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class SecurityTestController {

    private final MemberService memberService;

    @GetMapping("/member/{id}")
    public String member(@PathVariable Long id){
        return memberService.getUser(id).getEmail();
    }

}
