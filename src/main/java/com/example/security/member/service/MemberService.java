package com.example.security.member.service;

import com.example.security.member.entity.Member;
import com.example.security.member.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getUser(long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found user with id =" + id));
    }

    public Optional<Member> getUser(String email) {
        return memberRepository.findByEmail(email);
    }

    @Transactional
    public Member createUser(Member member) {
        return memberRepository.save(member);
    }
}
