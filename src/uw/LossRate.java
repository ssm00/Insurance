package uw;

import java.io.BufferedReader;
import java.io.IOException;

public class LossRate {
    private String accidentType; //사고종류
    private int coverageLimit; //보상한도
    private int insuranceFee; //보험료
    private int paidAmount; //지급된 보상액
    private float lossRate; //손해액
    

	//손해액 계산 함수, 계산된 손해액을 lossRate에 저장해야 함
    public float calculateLossRate(BufferedReader objectReader) throws IOException
        System.out.println("계산을 위한 데이터를 입력해주세요.");
        
        System.out.println("사고 종류 : ");
        accidentType = objectReader.readLine().trim();
        this.setAccidentType(accidentType);

        System.out.println("보상 한도 : ");
        coverageLimit = Integer.parseInt(objectReader.readLine());
        this.setCoverageLimit(coverageLimit);

        System.out.println("보험료 : ");
        insuranceFee = Integer.parseInt(objectReader.readLine());
        this.setInsuranceFee(insuranceFee);

        System.out.println("지급된 보상액 : ");
        this.paidAmount = Integer.parseInt(objectReader.readLine());
        this.setPaidAmount(paidAmount);
        
        this.lossRate = (float) ((paidAmount * 20) + (insuranceFee * 10) + (coverageLimit * 0.5));
     
        System.out.println("계산된 손해액은 : " + this.lossRate +" 입니다.");
 
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
