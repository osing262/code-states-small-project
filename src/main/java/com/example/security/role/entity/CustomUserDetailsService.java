package com.example.security.role.entity;

import com.example.security.member.entity.Member;
import com.example.security.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.getUser(username)
                .orElseThrow(() -> new UsernameNotFoundException("User is not found. email=" + username));

        member.setAuthorities(
                Stream.concat(
                        getRoles(member.getRoles()).stream(),
                        getPrivileges(member.getRoles()).stream()
                ).collect(Collectors.toList())
        );

        return member;
    }

    private List<SimpleGrantedAuthority> getRoles(List<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private List<SimpleGrantedAuthority> getPrivileges(List<Role> roles) {
        return roles.stream()
                .flatMap(role -> role.getPrivileges().stream())
                .map(privilege -> new SimpleGrantedAuthority(privilege.getName()))
                .collect(Collectors.toList());
    }
}
