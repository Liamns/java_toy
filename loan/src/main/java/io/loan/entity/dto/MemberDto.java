package io.loan.entity.dto;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import io.loan.entity.Member;
import io.loan.entity.vo.RedemptionMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "MEMBER")
public class MemberDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int loan;
    private double minRate;
    private double maxRate;
    private int redemptionYear;
    private RedemptionMethod redemptionMethod;

    public MemberDto(Member member) {
        BeanUtils.copyProperties(member, this);
    }

    public Member toEntity() {
        Member member = Member.builder()
                .loan(this.loan)
                .minRate(this.minRate)
                .maxRate(this.maxRate)
                .redemptionYear(this.redemptionYear)
                .redemptionMethod(this.redemptionMethod)
                .build();
        return member;
    }
}
