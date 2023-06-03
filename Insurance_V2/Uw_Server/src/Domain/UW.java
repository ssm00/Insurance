package Domain;

import java.io.Serializable;

public class UW implements Serializable {
    private boolean applicationForm; //청약서
    private boolean security;//증권
    private LossRate lossRate; //손해액

//    public UW(boolean applicationForm, boolean security, LossRate lossRate  ) {
//    	this.applicationForm = applicationForm;
//    	this.security = security;
//    	this.lossRate = lossRate;
//
//    }

    public boolean reinsuranceProcessign( Insurance choiceInsurance) {
        // 재보험 검증 및 재보험료 계산
        boolean isReinsuranceValidated = validate(choiceInsurance);
        if (isReinsuranceValidated) {
            double reinsurancePremium = calculateReinsuranceFee( choiceInsurance);
        } else {
            return false;
        }
        return true;
    }

    //재보험처리(재보험료계산)
    public int calculateReinsuranceFee(Insurance choiceInsurance) {
        int ReinsuranceFee = choiceInsurance.getCoverageAmount() + choiceInsurance.getCoveragePeriod(); //재보험료계산..
        return ReinsuranceFee;
    }

    //재보험처리(승인)
    public boolean validate(Insurance insurance) {
        // 재보험 검증 로직 수행
        // 필요한 검증 규칙을 구현하여 재보험 유효성을 판단
        return true; // 예시로 재보험 유효성을 항상 true로 가정
    }

    //인수심사
    public boolean underWriting( Insurance choiceInsurance) {
        this.setApplicationForm(true);
        this.setSecurity(true);
        boolean isAccepted = true;// 자동심사를 통한 인수 여부 결정 수행
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
