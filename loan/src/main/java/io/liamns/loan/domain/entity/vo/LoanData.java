package io.liamns.loan.domain.entity.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class LoanData {

    // 대출금
    private long loan;

    // 최소 연금리
    private double min;
    // 최대 연금리
    private double max;
    // 상환기간 (연도)
    private int redemptionYear;

    // 상환방식 (confirmDialog 값 받는 변수)
    private RedemptionMethod redemptionMethod;

    // 원리금균등상환 월 납입액
    public double getPrincipalInterestMonthly() {
        return loan * rateMonthly() * (Math.pow((1 + rateMonthly()), (getRedemptionMonth())))
                / (Math.pow((1 + rateMonthly()), (getRedemptionMonth())) - 1);
    }

    // 월금리 == 연금리 / 12
    public double rateMonthly() {
        return getRate() / 12;
    }

    // 대출상품 평균 금리
    public double getRate() {
        return (min + max) / 2;
    }

    // 연 이자 금액
    public double getInterstYearly() {
        return loan * getRate();
    }

    // 상환기간 (개월 수)
    public int getRedemptionMonth() {
        return redemptionYear * 12;
    }

    // 원금균등상환 시 원금
    public double getPrincipalMonthly() {
        return loan / getRedemptionMonth();
    }

    // 총 납입액 (value), 개월 수 별 납입액 (array)
    public class mainCalc {
        private double value;
        private double[] array;

        public mainCalc(double value, double[] array) {
            this.value = value;
            this.array = array;
        }

        public double getValue() {
            return value;
        }

        public double[] getArray() {
            return array;
        }
    }

    // 상환방식에 따른 총 납입액과 월 납입액 계산
    public mainCalc getMainCalc() {
        double value = 0.0;
        double[] array = new double[getRedemptionMonth()];

        if (redemptionMethod == RedemptionMethod.PrincipalRate) {
            for (int i = 0; i < getRedemptionMonth(); i++) {
                array[i] = getPrincipalInterestMonthly();
                value += array[i];
            }
        } else {
            for (int i = 0; i < getRedemptionMonth(); i++) {
                array[i] = getPrincipalMonthly() + (loan - getPrincipalMonthly() * i) * rateMonthly();
                value += array[i];
            }
        }

        return new mainCalc(value, array);
    }

}
