package view.secretary.patient.removepatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;

import controller.patient.RemovePatientController;

public class RemovePatientButtonHandler implements ActionListener {

	private RemovePatientController removePatientController;

	public RemovePatientButtonHandler(RemovePatientController removePatientController) {

		this.removePatientController = removePatientController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() instanceof JButton))
			return;
		if (((JButton) e.getSource()).getText().startsWith("Search")) {
			try {
				removePatientController.executes("Search");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (((JButton) e.getSource()).getText().startsWith("Remove")) {
			try {
				removePatientController.executes("Remove");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}