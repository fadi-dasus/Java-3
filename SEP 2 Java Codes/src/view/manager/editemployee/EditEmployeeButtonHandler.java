package view.manager.editemployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import controller.employee.manager.EditEmployeeController;

public class EditEmployeeButtonHandler implements ActionListener {

	private EditEmployeeController editEmployeeController;

	public EditEmployeeButtonHandler(EditEmployeeController editEmployeeController) {

		this.editEmployeeController = editEmployeeController;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JButton) {

			if (((JButton) e.getSource()).getText().startsWith("Search")) {
				try {
					editEmployeeController.executes("Search");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (((JButton) e.getSource()).getText().startsWith("Save")) {
				try {
					editEmployeeController.executes("Save");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		if (e.getSource() instanceof JComboBox)

		{
			try {
				editEmployeeController.executes("pickcmbBox");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}