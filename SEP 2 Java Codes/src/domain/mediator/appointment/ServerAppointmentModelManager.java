package domain.mediator.appointment;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import domain.model.patient.Appointment;
import domain.model.patient.AppointmentList;

public class ServerAppointmentModelManager extends UnicastRemoteObject implements RemoteAppointmentModel {
	private AppointmentPersistance persistance;
	private AppointmentList list;
	private AppointmentList freeAppointments;
	private boolean loadedFreeAppointments;

	public ServerAppointmentModelManager() throws ClassNotFoundException, RemoteException {

		this.persistance = new AppointmentDatabase();
		list = new AppointmentList();

		Registry reg = LocateRegistry.createRegistry(1097);
		reg.rebind("AppointmentServer", this);
		System.out.println("Starting Appointment Package....");

		freeAppointments = new AppointmentList();
		loadedFreeAppointments = false;
	}

	@Override
	public ArrayList<Appointment> getAllBookedAppointments() {

		return persistance.loadAllTheBookedAppointment();

	}

	public AppointmentList getAllFreeAppointment() {
		if (!loadedFreeAppointments) {
			freeAppointments = persistance.loadFreeAppointments();
			loadedFreeAppointments = true;
		}
		return freeAppointments;

	}

	public int getThisDateId(Date date) {
		return freeAppointments.getAssociateIdForDate(date);
	}

	@Override
	public void AddAppointmentToDBAndToList(Date date, String brief, int patientId, int dateId) {
		Appointment appointment = new Appointment(date, brief, patientId, dateId);
		list.addAppointment(appointment);
		persistance.save(appointment);

	}

	@Override
	public void removeAppointmentById(int id) {

		persistance.remove(id);

	}

}