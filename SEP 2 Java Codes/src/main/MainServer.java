package main;

import java.io.IOException;

import domain.mediator.appointment.ServerAppointmentModelManager;
import domain.mediator.patient.ServerPatientModelManager;
import domain.mediator.staff.ServerStaffClinicModelManager;

public class MainServer {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		ServerStaffClinicModelManager serverStaffClinicModelManager = new ServerStaffClinicModelManager();
		ServerPatientModelManager serverPatientModelManager = new ServerPatientModelManager();
		ServerAppointmentModelManager serverAppointmentModelManager = new ServerAppointmentModelManager();
		System.out.println("Server is Started....");
	}

}
