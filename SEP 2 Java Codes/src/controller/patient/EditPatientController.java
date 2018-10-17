package controller.patient;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import clients.Client;
import domain.model.patient.Patient;
import view.secretary.patient.editpatient.EditPatientView;

public class EditPatientController {
	private Client client;

	private EditPatientView editPatientView;

	

	public EditPatientController(Client client, EditPatientView editPatientView)
			throws ClassNotFoundException, IOException {

		this.client = client;
		this.editPatientView = editPatientView;
	}

	public void executes(String what) throws RemoteException {

		switch (what) {

		case "Search":

			String name = " ";
			name = editPatientView.getSearchTxtValue();
			if (name.length() > 1) {

				name = name.substring(0, 1).toUpperCase()
						+ editPatientView.getSearchTxtValue().substring(1).toLowerCase();
			}
				try {
					client.callLoadPateint(name);
				} catch (IOException e) {

					e.printStackTrace();
				}
			

			int[] ides = new int[client.getAllPatientsFromTheList().size()];
			for (int i = 0; i < ides.length; i++) {
				ides[i] = client.getAllPatientsFromTheList().get(i).getId();

			}

			editPatientView.setComboboxValue(ides);

			break;

		case "pickcmbBox":
			int id = editPatientView.getSelectedValueCmbox();
			Patient pat = client.getPatientByIdFromList(id);

			editPatientView.setFirstName(pat.getFirstName());
			editPatientView.setLastName(pat.getLastName());
			editPatientView.setDOB(pat.getDob());
			editPatientView.setTel(pat.getTelNumber());
			editPatientView.setEmail(pat.getEmail());
			editPatientView.setGender(pat.getGender());

			System.out.println("ComboBox");

			break;

		case "Save":
			int id1 = editPatientView.getSelectedValueCmbox();
			String firstName = editPatientView.getFirstName();
			String lastName = editPatientView.getLastName();
			String telNumber = editPatientView.getTel();
			String email = editPatientView.getEmail();
			String gender = editPatientView.getGender();

			String dob = editPatientView.getDate();

			SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date date1 = null;
			try {
				date1 = sdf2.parse(dob);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDOB = new java.sql.Date(date1.getTime());

			Patient pat2 = client.getPatientByIdFromList(id1);

			pat2.setFirstName(firstName);
			pat2.setLastName(lastName);
			pat2.setTelNumber(telNumber);
			pat2.setEmail(email);
			pat2.setGender(gender);
			pat2.setDob(sqlDOB);

			client.updatePatient(pat2);

			System.out.println("Save");

		default:

			break;
		}

	}
}