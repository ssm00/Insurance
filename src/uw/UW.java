package uw;

public class UW {
    private boolean applicationForm; //청약서
    private boolean security;//증권
    private LossRate lossRate; //손해액

    public int calculateReinsuranceFee() {
        return 0;
    }
    public boolean Reinsurance() {
        return true;
    }
    public float calculateLossRate() {
        return 1;
    }
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
