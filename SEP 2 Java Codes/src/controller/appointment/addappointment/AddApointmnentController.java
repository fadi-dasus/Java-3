package controller.appointment.addappointment;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import clients.Client;
import view.secretary.appointment.addappointment.AddAppointmentGUI;

public class AddApointmnentController {

	private Client client;
	private AddAppointmentGUI addAppointmentGUI;

	// Constructor takes client and the view as arguments
	public AddApointmnentController(Client client, AddAppointmentGUI addAppointmentGUI)
			throws ClassNotFoundException, IOException {

		this.addAppointmentGUI = addAppointmentGUI;
		this.client = client;

	}

	// execute method to perform the action caused by pressing the search button
	public void executeSearch() throws RemoteException {
		String name = ((AddAppointmentGUI) addAppointmentGUI).getSearchTxtValue();
		boolean error = false;
		if (name.isEmpty()) {
			addAppointmentGUI.showError();
			error = true;
		}
		if (error == false) {
			addAppointmentGUI.enableRemoveButton(true);
			if (name.length() > 1) {
				name = name.substring(0, 1).toUpperCase()
						+ ((AddAppointmentGUI) addAppointmentGUI).getSearchTxtValue().substring(1).toLowerCase();
			}
			try {
				client.callLoadPateint(name);
			} catch (IOException e) {
				e.printStackTrace();
			}
			addAppointmentGUI.showTable(client.getAllPatientsFromTheList());
			setPatientIdComboBoxValue();
			fillComboBoxForFreeAppointment();
		}
	}

	// extract patient id that is extracted from the objects that retrieved from the
	// database and fill it in the comboBox
	public void setPatientIdComboBoxValue() throws RemoteException {
		int[] ides = new int[client.getAllPatientsFromTheList().size()];
		for (int i = 0; i < ides.length; i++) {
			ides[i] = client.getAllPatientsFromTheList().get(i).getId();
		}
		addAppointmentGUI.setComboboxValue(ides);
	}

	// getting free appointment from the database and fill the combobox with it in
	// order to pick one and associated with one patientid
	public void fillComboBoxForFreeAppointment() throws RemoteException {
		Date[] freeAppointments = new Date[client.getAllFreeAppointment().getNumberOfAppointment()];
		for (int i = 0; i < freeAppointments.length; i++) {
			freeAppointments[i] = client.getAllFreeAppointment().getAppointmentByIndex(i).getDateOfAppointment();
		}
		addAppointmentGUI.fillComboBoxFreeAppointments(freeAppointments);
	}

	// execute method that will be called when the user press add button, it will
	// handle adding the appointment with its details and add it to the database
	// table
	public void executeAdd() throws RemoteException {
		String brief = addAppointmentGUI.getTextAreaValue();
		Date appointmentDate = addAppointmentGUI.getSelectedDate();
		int patientId = addAppointmentGUI.getSelectedPatientId();
		int id = client.getThisDateId(appointmentDate);
		client.AddAppointmentToDBAndToList(appointmentDate, brief, patientId, id);
		addAppointmentGUI.showConfirmation();
	}

}