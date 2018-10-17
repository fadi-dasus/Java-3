package domain.mediator.appointment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import domain.model.patient.Appointment;
import domain.model.patient.AppointmentList;

public interface RemoteAppointmentModel extends Remote {
	public ArrayList<Appointment> getAllBookedAppointments() throws RemoteException;

	public AppointmentList getAllFreeAppointment() throws RemoteException;

	public void AddAppointmentToDBAndToList(Date date, String brief, int patientId, int dateId) throws RemoteException;

	public void removeAppointmentById(int id) throws RemoteException;

	public int getThisDateId(Date date) throws RemoteException;

}