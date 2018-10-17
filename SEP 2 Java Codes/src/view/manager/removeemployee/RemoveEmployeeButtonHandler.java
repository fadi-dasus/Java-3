package view.manager.removeemployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;

import controller.employee.manager.RemoveEmlployeeController;

public class RemoveEmployeeButtonHandler implements ActionListener {

	private RemoveEmlployeeController removeEmlployeeController;

	public RemoveEmployeeButtonHandler(RemoveEmlployeeController removeEmlployeeController) {
		this.removeEmlployeeController = removeEmlployeeController;
	}

	public void actionPerformed(ActionEvent e) {

		if (!(e.getSource() instanceof JButton))
			return;
		if (((JButton) e.getSource()).getText().startsWith("Search")) {
			try {
				removeEmlployeeController.executes("Search");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (((JButton) e.getSource()).getText().startsWith("Remove")) {
			try {
				removeEmlployeeController.executes("Remove");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
