package controller.appointment.removeappointment;

import java.rmi.RemoteException;
import java.util.ArrayList;

import clients.Client;
import domain.mediator.appointment.RemoteAppointmentModel;
import domain.mediator.appointment.ServerAppointmentModelManager;
import domain.model.patient.Appointment;
import domain.model.patient.AppointmentList;
import view.secretary.appointment.removeappointment.RemoveAppointment;

public class RemoveAppointmentController {

	private RemoveAppointment view;
	private Client client;

	public RemoveAppointmentController(Client client, RemoveAppointment view) {

		this.view = view;
		this.client = client;

	}

	public void executeGetAllAppointments() throws RemoteException {
		ArrayList<Appointment> ides = new ArrayList<Appointment>();
		ides = client.getAllBookedAppointments();
		int[] idesComboBox = new int[client.getAllBookedAppointments().size()];
		for (int i = 0; i < ides.size(); i++) {

			idesComboBox[i] = ides.get(i).getDateOfAppointmentId();
		}
		view.showTable(client.getAllBookedAppointments());
		
		view.setComboboxValue(idesComboBox);
		if(idesComboBox.length>0) {
		
			view.enableRemoveButton(true);
		}
	}

	public void executeRemoveAppointment() throws RemoteException {
		int id = view.getSelectedItemFromBox();

		client.removeAppointmentById(id);
		executeGetAllAppointments();

	}
}
