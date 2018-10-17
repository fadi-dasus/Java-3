package domain.mediator.patient;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import domain.model.patient.Patient;
import domain.model.patient.PatientList;

public class ServerPatientModelManager extends UnicastRemoteObject implements RemotePatientModel {
	private PatientList list;
	private PatientDatabase persistence;
	private Patient patient;

	public ServerPatientModelManager() throws IOException, ClassNotFoundException {

		this.persistence = new PatientDatabase();
		list = new PatientList();

		Registry reg = LocateRegistry.createRegistry(1098);
		reg.rebind("PatientServer", this);
		System.out.println("Starting Patient Package....");
	}

	@Override
	public void LoadFromDB(String name) throws IOException {
		this.list = persistence.loadPatietByName(name);
	}

	@Override
	public void addPatient(String[] patientData) {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		Date dob = null;

		if (patientData[2] != null) {

			try {
				dob = format.parse(patientData[2]);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int id = 0;
			String firstName = patientData[0];
			String lastName = patientData[1];

			String telNumber = patientData[3];
			String email = patientData[4];
			String gender = patientData[5];
			patient = new Patient(id, firstName, lastName, dob, telNumber, email, gender);
			try {
				persistence.savePatient(patient);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public ArrayList<Patient> getPatientByName(String name) {
		Patient patient = list.getPatientByName(name);
		ArrayList<Patient> patients = new ArrayList<Patient>();
		if (patient != null) {
			patients.add(patient);
		}

		return patients;

	}

	@Override
	public ArrayList<Patient> getAllPatientsFromTheList() {

		return list.getAllPatientsFromTheList();

	}

	@Override
	public void removePatientById(int id) {
		Patient patient = list.getPatientById(id);
		if (patient != null) {
			list.removePatient(patient);
			try {
				persistence.removePatient(patient);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updatePatient(Patient patient) {
		try {
			persistence.updatePatient(patient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Patient getPatientByIdFromList(int id) throws RemoteException {
		return list.getPatientById(id);

	}
}
