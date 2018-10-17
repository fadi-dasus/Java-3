package domain.model.patient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentList implements Serializable {
	private ArrayList<Appointment> appointments;

	public AppointmentList() {
		this.appointments = new ArrayList<Appointment>();
	}

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	public void removeAppointment(Appointment appointment) {
		appointments.remove(appointment);
	}

	public int getAssociateIdForDate(Date date) {
		int id = 0;
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getDateOfAppointment().compareTo(date) == 0) {
				id = appointments.get(i).getDateOfAppointmentId();
			}
		}
		return id;
	}

	public ArrayList<Appointment> getAvailableAppointmentOnThisDate(Date dateOfAppointment) {
		ArrayList<Appointment> selectedAppointmentsOnDate = new ArrayList<Appointment>();
		for (int i = 0; i < appointments.size(); i++) {
			if (appointments.get(i).getDateOfAppointment().equals(dateOfAppointment)) {
				selectedAppointmentsOnDate.add(appointments.get(i));
			} else {
				System.out.println(" we do not have any appointmens in the given date  ");
			}

		}
		return selectedAppointmentsOnDate;
	}

	public int getNumberOfAppointment() {
		return appointments.size();
	}



	public Appointment getAppointmentByIndex(int index) {

		return appointments.get(index);
	}

}