package view.secretary.appointment.addappointment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;

import controller.appointment.addappointment.AddApointmnentController;

public class AddAppointmentButtonHandler implements ActionListener {
	private AddApointmnentController addApointmnentController;

	public AddAppointmentButtonHandler(AddApointmnentController addApointmnentController) {
		this.addApointmnentController = addApointmnentController;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (((JButton) e.getSource()).getText().startsWith("Search")) {
			try {
				addApointmnentController.executeSearch();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (((JButton) e.getSource()).getText().startsWith("Add")) {

			try {
				addApointmnentController.executeAdd();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}