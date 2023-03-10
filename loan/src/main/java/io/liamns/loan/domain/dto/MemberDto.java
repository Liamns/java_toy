package io.liamns.loan.domain.dto;

import io.liamns.loan.domain.entity.Member;
import io.liamns.loan.domain.vo.RedemptionMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDto {

    private Integer memberId;
    private long memberLoan;
    private double memberMin;
    private double memberMax;
    private int memberRedemptionYear;
    private RedemptionMethod membRedemptionMethod;

    public Member toEntity() {
        return Member.builder()
                .id(memberId)
                .loan(memberLoan)
                .min(memberMin)
                .max(memberMax)
                .redemptionYear(memberRedemptionYear)
                .redemptionMethod(membRedemptionMethod)
                .build();
    }
}
