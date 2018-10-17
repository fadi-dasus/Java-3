package controller.employee.manager;

import java.io.IOException;
import java.rmi.RemoteException;

import clients.Client;
import view.manager.searchemployee.SearchEmployeeGUI;
import view.manager.searchemployee.SearchEmployeeView;

public class SearchEmployeeController {
	private Client client;
	private SearchEmployeeView searchEmployeeview;

	public SearchEmployeeController(Client client, SearchEmployeeView searchEmployeeview)
			throws ClassNotFoundException, IOException {

		this.client = client;

		this.searchEmployeeview = searchEmployeeview;

	}

	public void executes() throws RemoteException {
		String name = ((SearchEmployeeGUI) searchEmployeeview).getNameValue();
		if (name.length() > 1) {

			name = name.substring(0, 1).toUpperCase()
					+ ((SearchEmployeeGUI) searchEmployeeview).getNameValue().substring(1).toLowerCase();
		}

		try {
			client.callLoadStaff(name);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		searchEmployeeview.showTable(client.getAllEmployeesFromTheList());
	}

}
