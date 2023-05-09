package uw;

public class UW {
    private boolean applicationForm; //청약서
    private boolean security;//증권
    private LossRate lossRate; //손해액

    //재보험처리(재보험료계산)
    public int calculateReinsuranceFee() {
        return 0;
    }

    //재보험처리(승인)
    public boolean Reinsurance() {
        return true;
    }

    //손해율계산
    public float calculateLossRate() {
        return 1;
    }

    //인수심사
    public boolean underWriting() {
        return true;
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
