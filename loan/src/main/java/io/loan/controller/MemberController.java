package io.loan.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.loan.entity.Member;
import io.loan.service.Memberservice;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final Memberservice memberservice;

    @PostMapping("/members")
    public Long register(@RequestBody Member member) {
        return memberservice.save(member);
    }

    @GetMapping("/members/{id}")
    public Optional<Member> findById(@PathVariable Long id) {
        return memberservice.findById(id);
    }
}
