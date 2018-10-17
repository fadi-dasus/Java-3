package domain.mediator.patient;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import domain.model.patient.Patient;

public interface RemotePatientModel extends Remote {
	public void LoadFromDB(String name) throws IOException, RemoteException;

	public void addPatient(String[] patientData) throws RemoteException;

	public ArrayList<Patient> getPatientByName(String name) throws RemoteException;

	public void removePatientById(int id) throws RemoteException;

	public ArrayList<Patient> getAllPatientsFromTheList() throws RemoteException;

	public void updatePatient(Patient patient) throws RemoteException;

	public Patient getPatientByIdFromList(int id) throws RemoteException;

}
