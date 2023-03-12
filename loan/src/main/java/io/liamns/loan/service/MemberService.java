package io.liamns.loan.service;

import java.util.List;

import io.liamns.loan.domain.dto.MemberDto;
import io.liamns.loan.domain.entity.vo.RedemptionMethod;

public interface MemberService {

    MemberDto saveMember(Integer memberId, long memberLoan, double memberMin, double memberMax,
            int memberRedemptionYear, RedemptionMethod membRedemptionMethod);

    MemberDto getMember(Integer memberId);

    List<MemberDto> getMemberAll();

    double totlaPayment(Integer id);

    List<Double> monthlyPayment(Integer id);
}
