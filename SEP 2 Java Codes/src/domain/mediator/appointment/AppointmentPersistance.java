package domain.mediator.appointment;

import java.util.ArrayList;

import domain.model.patient.Appointment;
import domain.model.patient.AppointmentList;

public interface AppointmentPersistance {
	public ArrayList<Appointment> loadAllTheBookedAppointment();

	public AppointmentList loadFreeAppointments();

	public void save(Appointment appointment);

	public void remove(int id);

}