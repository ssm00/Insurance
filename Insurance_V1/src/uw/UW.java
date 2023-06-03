package uw;

import java.io.BufferedReader;
import java.io.IOException;

import insurance.Insurance;

public class UW {
    private boolean applicationForm; //청약서
    private boolean security;//증권
    private LossRate lossRate; //손해액
    
//    public UW(boolean applicationForm, boolean security, LossRate lossRate  ) {
//    	this.applicationForm = applicationForm;
//    	this.security = security;
//    	this.lossRate = lossRate;
// 	
//    }
    
	public boolean reinsuranceProcessign(BufferedReader objectReader, Insurance choiceInsurance) {
		System.out.println("재보험 처리를 진행합니다.");
        // 재보험 검증 및 재보험료 계산
        boolean isReinsuranceValidated = validate(choiceInsurance);
        if (isReinsuranceValidated) {
            double reinsurancePremium = calculateReinsuranceFee(objectReader, choiceInsurance);
            System.out.println(choiceInsurance.getInsuranceName() + ": 재보험 승인이 성공되었습니다. ");
            System.out.println(choiceInsurance.getInsuranceName() + " 재보험료 : " + reinsurancePremium);
        } else {
            System.out.println(choiceInsurance.getInsuranceName() + ": 재보험 승인에 실패했습니다. ");
        }
		return true;
	}

    //재보험처리(재보험료계산)
    public int calculateReinsuranceFee(BufferedReader objectReader, Insurance choiceInsurance) {
    	
    	int ReinsuranceFee = choiceInsurance.getCoverageAmount() + choiceInsurance.getCoveragePeriod(); //재보험료계산..
    			
        return ReinsuranceFee;
    }

    //재보험처리(승인)    
    public boolean validate(Insurance insurance) {
        // 재보험 검증 로직 수행
        // 필요한 검증 규칙을 구현하여 재보험 유효성을 판단
        return true; // 예시로 재보험 유효성을 항상 true로 가정
    }
    

    //손해율계산
    public float calculateLossRate(BufferedReader objectReader) throws IOException {
    	this.lossRate = new LossRate();
		return lossRate.calculateLossRate(objectReader);
    }

    //인수심사
    public boolean underWriting(BufferedReader objectReader, Insurance choiceInsurance) {
    	
    	System.out.println("인수 심사를 진행합니다.");
        System.out.println("----청약서 확인----");
        this.setApplicationForm(true);
        System.out.println("----증권 확인----");
        this.setSecurity(true);
    	
        boolean isAccepted = true;// 자동심사를 통한 인수 여부 결정 수행
        
        if (isAccepted) {
        	System.out.println("보험 " + choiceInsurance.getInsuranceName() + "에 대한 인수 심사가 성공했습니다.");
        	} 
        else {
        	System.out.println("보험 " + choiceInsurance.getInsuranceName() + "에 대한 인수 심사에 실패했습니다.");
        	}
        return isAccepted;
    }
    


    //---getter & setter---
    public boolean getSecurity() {
        return security;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    public boolean getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(boolean applicationForm) {
        this.applicationForm = applicationForm;
    }


}
