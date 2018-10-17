package controller.employee.manager;

import java.io.IOException;
import java.rmi.RemoteException;

import clients.Client;
import view.manager.removeemployee.RemoveEmployeeGUI;

public class RemoveEmlployeeController {

	private Client client;
	private RemoveEmployeeGUI removeEmployeeGUI;

	public RemoveEmlployeeController(Client client, RemoveEmployeeGUI removeEmployeeGUI)
			throws ClassNotFoundException, IOException {

		this.client = client;
		this.removeEmployeeGUI = removeEmployeeGUI;
	}

	public void executes(String what) throws RemoteException {

		switch (what) {
		case "Search":
			String name = "";
			if (((RemoveEmployeeGUI) removeEmployeeGUI).getSearchTxtValue().length() > 0) {
				name = ((RemoveEmployeeGUI) removeEmployeeGUI).getSearchTxtValue().substring(0, 1).toUpperCase()
						+ ((RemoveEmployeeGUI) removeEmployeeGUI).getSearchTxtValue().substring(1).toLowerCase();
			}

			try {
				client.callLoadStaff(name);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			removeEmployeeGUI.showTable(client.getAllEmployeesFromTheList());
			int[] ides = new int[client.getAllEmployeesFromTheList().size()];
			for (int i = 0; i < ides.length; i++) {
				ides[i] = client.getAllEmployeesFromTheList().get(i).getId();

			}
			if (ides.length > 0) {
				removeEmployeeGUI.enableRemoveButton(true);
			}

			removeEmployeeGUI.setComboboxValue(ides);

			break;
		case "Remove":

			int id = removeEmployeeGUI.getSelectedItemFromBox();

			client.removeStaff(id);
			removeEmployeeGUI.showTable(client.getAllEmployeesFromTheList());

			break;

		default:
			break;
		}

	}

}
