package io.liamns.loan.domain.dao.impl;

import org.springframework.stereotype.Service;

import io.liamns.loan.domain.dao.MemberDao;
import io.liamns.loan.domain.entity.Member;
import io.liamns.loan.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao {

    private final MemberRepository memberRepository;

    @Override
    public Member registerMember(Member member) {
        memberRepository.save(member);
        return member;
    }

    @Override
    public Member getMember(Integer id) {
        Member member = memberRepository.findById(id).get();
        return member;
    }
}
