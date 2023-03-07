package io.loan.service;

import java.util.UUID;

import io.loan.entity.Member;

public interface Memberservice {

    UUID create(Member member);

    double getPrincipalInterestMonthly(int loan);

    double rateMonthly();

    double getRate(double minRate, double maxRate);

    double getInterestYearly(int loan);

    int getRedemptionMonth(int loan);
}
