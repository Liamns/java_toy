package io.loan.entity;

import com.google.gson.Gson;

import io.loan.entity.vo.RedemptionMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
