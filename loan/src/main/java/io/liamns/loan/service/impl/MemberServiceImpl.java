package io.liamns.loan.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import org.springframework.stereotype.Service;

import io.liamns.loan.domain.dao.MemberDao;
import io.liamns.loan.domain.dto.MemberDto;
import io.liamns.loan.domain.entity.Member;
import io.liamns.loan.domain.entity.vo.LoanData;
import io.liamns.loan.domain.entity.vo.RedemptionMethod;
import io.liamns.loan.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;
    private final LoanData loanData;

    @Override
    public MemberDto saveMember(Integer memberId, long memberLoan, double memberMin, double memberMax,
            int memberRedemptionYear, RedemptionMethod membRedemptionMethod) {

        Member member = memberDao.registerMember(memberId, memberLoan, memberMin, memberMax, memberRedemptionYear,
                membRedemptionMethod);

        return member.toDto();
    }

    @Override
    public MemberDto getMember(Integer memberId) {

        Member member = memberDao.getMember(memberId);

        return member.toDto();
    }

    @Override
    public List<MemberDto> getMemberAll() {
        List<Member> members = memberDao.getMemberAll();
        return members.stream().map(member -> member.toDto()).collect(Collectors.toList());
    }

    @Override
    public double totlaPayment(Integer id) {
        Member member = memberDao.getMember(id);

        loanData.setLoan(member.getLoan());
        loanData.setMax(member.getMax());
        loanData.setMin(member.getMin());
        loanData.setRedemptionMethod(member.getRedemptionMethod());
        loanData.setRedemptionYear(member.getRedemptionYear());

        return loanData.getMainCalc().getValue();
    }

    @Override
    public List<Double> monthlyPayment(Integer id) {
        Member member = memberDao.getMember(id);

        loanData.setLoan(member.getLoan());
        loanData.setMax(member.getMax());
        loanData.setMin(member.getMin());
        loanData.setRedemptionMethod(member.getRedemptionMethod());
        loanData.setRedemptionYear(member.getRedemptionYear());

        double[] array = loanData.getMainCalc().getArray();

        return DoubleStream.of(array).boxed().collect(Collectors.toList());
    }

}