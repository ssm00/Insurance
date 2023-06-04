package Domain;
import utils.EmptyValueException;

public class Demand {
	private int accidentDate;
	private String accidentType;
	private int copyofIdentification;
	private String details;
	private String diagnosis;
	private int documentaryEvidence;
	private String treatmentHospital;
	private String demandId;
	private String customerName;
	private String accountNumber;
	private String bank;
	private String information;
	public Demand(String demandId, int accidentDate, String accidentType,
	            int copyofIdentification, String details, String diagnosis, 
			    int documentaryEvidence, String treatmentHospital,
				String customerName, String accountNumber, String bank, 
				String information) {
		this.accidentDate = accidentDate;
		this.accidentType = accidentType;
		this.copyofIdentification = copyofIdentification;
		this.details = details;
		this.diagnosis = diagnosis;
		this.documentaryEvidence = documentaryEvidence;
		this.treatmentHospital = treatmentHospital;
		this.demandId = demandId;
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.information = information;
	}
	public boolean demand() throws EmptyValueException {
		if (accidentDate == 0) {
			throw new EmptyValueException("사고 일자 정보가 누락되었습니다.");
		} else if (accidentType == null) {
			throw new EmptyValueException("사고 유형 정보가 누락되었습니다.");
		} else if (diagnosis == null) {
			throw new EmptyValueException("진단명 정보가 누락되었습니다.");
		} else if (treatmentHospital == null) {
			throw new EmptyValueException("치료 병원 정보가 누락되었습니다.");
		} else if (details == null) {
			throw new EmptyValueException("상세 내용이 누락되었습니다.");
		} else return false;
	}
	public boolean attach(int copyofIdentification, int documentaryEvidence){
		this.documentaryEvidence = documentaryEvidence;
		this.copyofIdentification = copyofIdentification;
		return false;
	}
	public int getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(int accidentDate) {
		this.accidentDate = accidentDate;
	}
	public String getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	public int getCopyofIdentification() {
		return copyofIdentification;
	}
	public void setCopyofIdentification(int copyofIdentification) {
		this.copyofIdentification = copyofIdentification;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public int getDocumentaryEvidence() {
		return documentaryEvidence;
	}
	public void setDocumentaryEvidence(int documentaryEvidence) {
		this.documentaryEvidence = documentaryEvidence;
	}
	public String getTreatmentHospital() {
		return treatmentHospital;
	}
	public void setTreatmentHospital(String treatmentHospital) {
		this.treatmentHospital = treatmentHospital;
	}
	public String getDemandId() {
		return demandId;
	}
	public void setDemandId(String demandId) {
		this.demandId = demandId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
}
