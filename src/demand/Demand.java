package demand;
import utils.EmptyValueException;

import java.util.UUID;
public class Demand {
	private int accidentDate;
	private int accidentType;
	private int copyofIdentification;
	private String details;
	private String diagnosis;
	private int documentaryEvidence;
	private String treatmentHospital;
	private String demandId;
	public Demand(int accidentDate,int accidentType, int copyofIdentification, String details, String diagnosis, int documentaryEvidence, String treatmentHospital) {
		this.accidentDate = accidentDate;
		this.accidentType = accidentType;
		this.copyofIdentification = copyofIdentification;
		this.details = details;
		this.diagnosis = diagnosis;
		this.documentaryEvidence = documentaryEvidence;
		this.treatmentHospital = treatmentHospital;
		this.demandId = UUID.randomUUID().toString();
	}
	public boolean demand() throws EmptyValueException {
		if (accidentDate == 0) {
			throw new EmptyValueException("사고 일자 정보가 누락되었습니다.");
		} else if (accidentType == 0) {
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
	public int getAccidentType() {
		return accidentType;
	}
	public void setAccidentType(int accidentType) {
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
}
