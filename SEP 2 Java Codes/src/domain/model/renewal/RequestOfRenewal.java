package domain.model.renewal;

import java.util.ArrayList;
import java.util.Date;

import domain.model.patient.Patient;

public class RequestOfRenewal {
private ArrayList<RecordOfRequestForRenewal> recordsRequest;
private Patient patient;
private Date dateOfRequest;
private Date dateOfDecision;
public RequestOfRenewal(Patient patient, Date dateOfRequest, Date dateOfDecision) {
	this.recordsRequest=new ArrayList<RecordOfRequestForRenewal>();
	this.patient = patient;
	this.dateOfRequest = dateOfRequest;
	this.dateOfDecision = dateOfDecision;
}
@Override
public String toString() {
	return "RequestOfRenewal [recordsRequest=" + recordsRequest + ", patient=" + patient + ", dateOfRequest="
			+ dateOfRequest + ", dateOfDecision=" + dateOfDecision + "]";
}
public Date getDateOfRequest() {
	return dateOfRequest;
}
public void setDateOfRequest(Date dateOfRequest) {
	this.dateOfRequest = dateOfRequest;
}
public Date getDateOfDecision() {
	return dateOfDecision;
}
public void setDateOfDecision(Date dateOfDecision) {
	this.dateOfDecision = dateOfDecision;
}
public ArrayList<RecordOfRequestForRenewal> getRecordsRequest() {
	return recordsRequest;
}
public Patient getPatient() {
	return patient;
}
}
