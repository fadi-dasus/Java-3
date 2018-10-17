package domain.model.patient;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {

	private Date dateOfAppointment;
	private String brief;
	private int patientid;
	private int dateOfAppointmentId;
	private String patientName;

	public String getPatientName() {
		return patientName;
	}

	public Appointment(String patientName, Date dateOfAppointment, String brief, int dateOfAppointmentId) {
		this.patientName = patientName;
		this.dateOfAppointment = dateOfAppointment;
		this.brief = brief;
		this.dateOfAppointmentId = dateOfAppointmentId;
	}

	public Appointment(Date dateOfAppointment, int dateOfAppointmentId) {
		this.dateOfAppointment = dateOfAppointment;
		this.dateOfAppointmentId = dateOfAppointmentId;
	}

	public int getPatientid() {
		return patientid;
	}

	public int getDateOfAppointmentId() {
		return dateOfAppointmentId;
	}

	public Appointment(Date dateOfAppointment, String brief, int patientid, int dateOfAppointmentId) {
		this.dateOfAppointment = dateOfAppointment;
		this.dateOfAppointmentId = dateOfAppointmentId;
		this.brief = brief;
		this.patientid = patientid;
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getPatient() {
		return patientid;
	}

	public void setPatient(int patientid) {
		this.patientid = patientid;
	}

	@Override
	public String toString() {
		return " dateOfAppointment=" + dateOfAppointment + ", brief=" + brief + ", patientId=" + patientid + "]";
	}

}