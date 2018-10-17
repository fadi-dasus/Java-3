package controller.patient;

import java.io.IOException;
import java.rmi.RemoteException;

import clients.Client;
import view.secretary.patient.searchpatient.SearchPatientView;

public class SearchPatientController {

	private Client client;
	private SearchPatientView searchPatientView;

	public SearchPatientController(Client client, SearchPatientView searchPatient)
			throws ClassNotFoundException, IOException {
		this.client = new Client();
		this.searchPatientView = searchPatient;

	}

	public void executes() throws RemoteException {
		String name = searchPatientView.getNameValue().substring(0, 1).toUpperCase()
				+ searchPatientView.getNameValue().substring(1).toLowerCase();

		try {
			client.callLoadPatient(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		searchPatientView.showTable(client.getAllPatientsFromTheList());

	}
}