package io.loan.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.loan.entity.Member;
import io.loan.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Memberservice {
    private final MemberRepository memberRepository;

    public Long save(Member member) {
        memberRepository.save(Member.builder()
                .loan(member.getLoan())
                .minRate(member.getMinRate())
                .maxRate(member.getMaxRate())
                .redemptionYear(member.getRedemptionYear())
                .redemptionMethod(member.getRedemptionMethod())
                .build());

        Long memberId = member.getId();
        return memberId;
    }

    public Optional<Member> findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }
}
