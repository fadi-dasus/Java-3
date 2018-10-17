package view.secretary.patient.editpatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import controller.patient.EditPatientController;

public class EditPatientButtonHandler implements ActionListener {
	private EditPatientController editPatientController;

	public EditPatientButtonHandler(EditPatientController editPatientController) {

		this.editPatientController = editPatientController;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JButton) {

			if (((JButton) e.getSource()).getText().startsWith("Search")) {
				try {
					editPatientController.executes("Search");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (((JButton) e.getSource()).getText().startsWith("Save")) {
				try {
					editPatientController.executes("Save");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		if (e.getSource() instanceof JComboBox)

		{
			try {
				editPatientController.executes("pickcmbBox");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}