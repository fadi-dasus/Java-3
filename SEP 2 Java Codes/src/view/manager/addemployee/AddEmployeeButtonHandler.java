package view.manager.addemployee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;

import controller.employee.manager.AddEmployeeController;

public class AddEmployeeButtonHandler implements ActionListener {
	private AddEmployeeView addEmployeeView;
	private AddEmployeeController addEmployeeController;

	public AddEmployeeButtonHandler(AddEmployeeGUI addEmployeeGUI, AddEmployeeController addEmployeeController) {

		this.addEmployeeView = addEmployeeView;
		this.addEmployeeController = addEmployeeController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() instanceof JButton))
			return;

		try {
			addEmployeeController.executes();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
