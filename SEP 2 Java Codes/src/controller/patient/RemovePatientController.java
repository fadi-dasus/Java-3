package controller.patient;

import java.io.IOException;
import java.rmi.RemoteException;

import clients.Client;
import view.secretary.patient.removepatient.RemovePatientGUI;
import view.secretary.patient.removepatient.RemovePatientView;

public class RemovePatientController {
	private Client client;
	private RemovePatientView removePatientView;

	public RemovePatientController(Client patientModel, RemovePatientGUI removePatientGUI)
			throws ClassNotFoundException, IOException {
		this.client = new Client();
		this.removePatientView = removePatientGUI;
	}

	public void executes(String what) throws RemoteException {
		switch (what) {
		case "Search":
			String name = "";
			if (removePatientView.getSearchTxtValue().length() > 0) {
				name = (removePatientView.getSearchTxtValue().substring(0, 1).toUpperCase()
						+ removePatientView.getSearchTxtValue().substring(1).toLowerCase());
			}
			removePatientView.enableRemoveButton(true);
			try {
				client.callLoadPatient(name);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			removePatientView.showTable(client.getAllPatientsFromTheList());
			int[] ides = new int[client.getAllPatientsFromTheList().size()];
			for (int i = 0; i < ides.length; i++) {
				ides[i] = client.getAllPatientsFromTheList().get(i).getId();

			}

			removePatientView.setComboboxValue(ides);

			break;
		case "Remove":

			int id = removePatientView.getSelectedItemFromBox();
			client.removePatient(id);
			removePatientView.showTable(client.getAllPatientsFromTheList());

			break;

		default:
			break;
		}

	}

}
