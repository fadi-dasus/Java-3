package controller.employee.manager;

import java.io.IOException;
import java.rmi.RemoteException;

import clients.Client;
import view.manager.addemployee.AddEmployeeView;

public class AddEmployeeController {
	private Client client;
	private AddEmployeeView view;

	public AddEmployeeController(Client client, AddEmployeeView view)
			throws ClassNotFoundException, IOException {
		
		this.client = client;
		this.view = view;
	}

	public String[] setComboboxValue() throws RemoteException {
		return client.reachType();
	}

	public void executes() throws RemoteException {
      String[] data = view.getTextFieldValues();


      boolean error = false;
      for (int i = 0; i < data.length; i++) {
          if (data[i].isEmpty()) {
              view.showError();
              error = true;
              break;
          }
      }
      if (error == false) {
         client.addEmployee(data);
          view.showConfirmation();
          view.cleanInput();
      }

  }
}
