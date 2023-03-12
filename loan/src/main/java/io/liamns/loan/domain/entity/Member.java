package io.liamns.loan.domain.entity;

import io.liamns.loan.domain.dto.MemberDto;
import io.liamns.loan.domain.entity.vo.RedemptionMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    private Integer id;

    private long loan;
    private double min;
    private double max;
    private int redemptionYear;
    private RedemptionMethod redemptionMethod;

    public MemberDto toDto() {
        return MemberDto.builder()
                .memberId(id)
                .memberLoan(loan)
                .memberMin(min)
                .memberMax(max)
                .memberRedemptionYear(redemptionYear)
                .membRedemptionMethod(redemptionMethod)
                .build();
    }
}
