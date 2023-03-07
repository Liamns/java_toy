package io.loan.entity;

import java.util.UUID;

import com.google.gson.Gson;

import io.loan.entity.dto.MemberDto;
import io.loan.entity.vo.RedemptionMethod;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Member {

    private UUID id;
    private int loan;
    private double minRate;
    private double maxRate;
    private int redemptionYear;
    private RedemptionMethod redemptionMethod;

    @Builder
    public Member(int loan, double minRate, double maxRate, int redemptionYear,
            RedemptionMethod redemptionMethod) {
        this.loan = loan;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.redemptionYear = redemptionYear;
        this.redemptionMethod = redemptionMethod;
    }

    public MemberDto toDto() {
        return MemberDto.builder()
                .loan(loan)
                .minRate(minRate)
                .maxRate(maxRate)
                .redemptionYear(redemptionYear)
                .redemptionMethod(redemptionMethod)
                .build();
    }

    public static Member sample() {
        Member sample = Member.builder()
                .loan(40000)
                .minRate(0.03)
                .minRate(0.034)
                .redemptionYear(15)
                .redemptionMethod(RedemptionMethod.Principal)
                .build();
        return sample;
    }

    public static void main(String[] args) {
        Member member = Member.builder().loan(20000).minRate(0.03).maxRate(0.035).redemptionYear(20)
                .redemptionMethod(RedemptionMethod.PrincipalRate).build();
        System.out.println(new Gson().toJson(member));
    }
}
