import javax.swing.JOptionPane;

class loanCalc {
    // 대출금
    public double loan;

    // 최소 연금리
    public double minRate;
    // 최대 연금리
    public double maxRate;
    // 상환기간 (연도)
    public int redemptionPeriodYear;
    
    // 상환방식 (confirmDialog 값 받는 변수)
    public int redemptionMethod;
    // redemptionMethod 의 결과를 문자열로
    public String redemptionMethodString;

    // 원리금균등상환 월 납입액
    public double getPrincipalInterestMonthly() {
        return loan*rateMonthly()*(Math.pow((1+rateMonthly()), (getRedemptionPeriodMonthly()))) / (Math.pow((1+rateMonthly()), (getRedemptionPeriodMonthly()))-1);
    }

    // 월금리 == 연금리 / 12
    public double rateMonthly() {
        return getRate() / 12;
    }

    // 대출상품 평균 금리
    public double getRate() {
        return (minRate + maxRate) / 2;
    }

    // 연 이자 금액
    public double getInterstYearly() {
        return loan * getRate();
    }

    // 상환기간 (개월 수)
    public int getRedemptionPeriodMonthly() {
        return redemptionPeriodYear*12;
    }

    // 원금균등상환 시 원금
    public double getPrincipalMonthly() {
        return loan / getRedemptionPeriodMonthly();
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
        double value  = 0.0;
        double[] array = new double[getRedemptionPeriodMonthly()];

        if (redemptionMethod == 0) {
            for (int i = 0; i < getRedemptionPeriodMonthly(); i++) {
                array[i] = getPrincipalInterestMonthly();
                value += array[i];
            }
        } else {
            for (int i = 0; i < getRedemptionPeriodMonthly(); i++) {
                array[i] = getPrincipalMonthly() + (loan - getPrincipalMonthly()*i) * rateMonthly();
                value += array[i];
            }
        }

        return new mainCalc(value, array);
    }
    

    // 출력 내용
    public void print() {
        System.out.println("총납입액 : " + String.format("%.2f", getMainCalc().value) + "원");
        int i = 0;
        for (double d : getMainCalc().array) {
            System.out.println(i+1 + "개월 납입액 : " + String.format("%.2f", d) + "원");
            i++;
        }
        
    }
}

public class loanCalcMethod {

    public static void main(String[] args) {
        
        loanCalc myLoan = new loanCalc();
        myLoan.loan = Double.parseDouble(JOptionPane.showInputDialog("대출금을 입력해주세요.(단위 : 만원)")) * 10000;
        myLoan.maxRate = Double.parseDouble(JOptionPane.showInputDialog("최대 이자율을 입력해주세요(예 : 0.05)"));
        myLoan.minRate = Double.parseDouble(JOptionPane.showInputDialog("최소 이자율을 입력해주세요(예 : 0.01)"));
        myLoan.redemptionPeriodYear = Integer.parseInt(JOptionPane.showInputDialog(null, "상환기간을 입력해주세요(연 단위)."));
        myLoan.redemptionMethod = JOptionPane.showConfirmDialog(null, "대출상환 방식을 선택해주세요 (예 : 원리금 / 아니오 : 원금)", null, 2);

        myLoan.print();
    }
}

