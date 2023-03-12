package io.liamns.loan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.liamns.loan.domain.dto.MemberDto;
import io.liamns.loan.domain.entity.vo.RedemptionMethod;
import io.liamns.loan.service.MemberService;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public MemberDto getMember(@PathVariable(name = "memberId") Integer memberId) {
        return memberService.getMember(memberId);
    }

    @GetMapping("")
    public List<MemberDto> getMemberAll() {
        return memberService.getMemberAll();
    }

    @PostMapping("")
    public MemberDto registerMember(@RequestBody MemberDto memberDto) {
        Integer id = memberDto.getMemberId();
        long loan = memberDto.getMemberLoan();
        double min = memberDto.getMemberMin();
        double max = memberDto.getMemberMax();
        int redemptionYear = memberDto.getMemberRedemptionYear();
        RedemptionMethod redemptionMethod = memberDto.getMembRedemptionMethod();

        return memberService.saveMember(id, loan, min, max, redemptionYear, redemptionMethod);
    }

    @GetMapping("/total")
    public double getMemberTotalPayment(@RequestParam("memberId") Integer memberId) {
        return memberService.totlaPayment(memberId);
    }

    @GetMapping("/monthly")
    public List<Double> getMemberMonthlyPayment(@RequestParam("memberId") Integer memberId) {
        return memberService.monthlyPayment(memberId);
    }
}
