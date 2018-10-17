package domain.model.medicalrecord;

import java.util.ArrayList;
import java.util.Date;

import domain.model.patient.Patient;

public class Prescription {
	private int PrescriptionId;
	private ArrayList<PrescriptionRecord> prescrptionRecords;
	private Date date;
	private Patient patient;
	
	public Prescription(int prescriptionId, Date date, Patient patient) {
		PrescriptionId = prescriptionId;
		this.prescrptionRecords = new ArrayList<PrescriptionRecord>();
		this.date = date;
		this.patient = patient;
	}
	public int getPrescriptionId() {
		return PrescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		PrescriptionId = prescriptionId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Prescription [PrescriptionId=" + PrescriptionId + ", prescrptionRecords=" + prescrptionRecords
				+ ", date=" + date + ", patient=" + patient + "]";
	}

}
