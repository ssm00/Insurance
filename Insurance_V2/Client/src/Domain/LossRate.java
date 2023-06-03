package Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

public class LossRate implements Serializable {
    private String accidentType; //사고종류
    private int coverageLimit; //보상한도
    private int insuranceFee; //보험료
    private int paidAmount; //지급된 보상액
    private float lossRate; //손해액


    //손해액 계산 함수, 계산된 손해액을 lossRate에 저장해야 함
    float calculateLossRate(String accidentType,int paidAmount, int insuranceFee, int coverageLimit) {
        this.lossRate = (float) ((paidAmount * 20) + (insuranceFee * 10) + (coverageLimit * 0.5));
        return this.lossRate;
    }

    //---getter & setter---
    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public float getLossRate() {
        return lossRate;
    }

    public void setLossRate(float lossRate) {
        this.lossRate = lossRate;
    }

    public int getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(int insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public int getCoverageLimit() {
        return coverageLimit;
    }

    public void setCoverageLimit(int coverageLimit) {
        this.coverageLimit = coverageLimit;
    }

    public String getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

}
