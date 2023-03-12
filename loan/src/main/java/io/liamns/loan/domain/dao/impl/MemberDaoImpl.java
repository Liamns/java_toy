package io.liamns.loan.domain.dao.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import io.liamns.loan.domain.dao.MemberDao;
import io.liamns.loan.domain.entity.Member;
import io.liamns.loan.domain.entity.vo.RedemptionMethod;
import io.liamns.loan.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao {

    private final MemberRepository memberRepository;

    @Override
    public Member getMember(Integer id) {
        Member member = memberRepository.findById(id).get();
        return member;
    }

    @Override
    public Member registerMember(Integer id, long loan, double min, double max, int redemptionYear,
            RedemptionMethod redemptionMethod) {
        Member member = Member.builder()
                .id(id)
                .loan(loan)
                .min(min)
                .max(max)
                .redemptionYear(redemptionYear)
                .redemptionMethod(redemptionMethod)
                .build();

        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMemberAll() {
        return memberRepository.findAll();
    }
}
