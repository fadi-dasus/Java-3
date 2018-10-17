package controller.employee.manager;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import clients.Client;
import domain.model.staff.Employee;
import view.manager.addemployee.AddEmployeeView;

public class TestAddEmployeeController {
	private Client client;
	private AddEmployeeView addEmployeeView = new AddEmployeeView() {
		@Override
		public void start(AddEmployeeController controller) {
		}
		@Override
		public String[] getTextFieldValues() {
			String[] data = { "Nadeem", "Muhammad", "1980-01-01", "2018-01-01", "42315678", "nadeem@yahoo", "M","Doctor" };
			return data;
		}
		@Override
		public void showError() {
				}
		@Override
		public void showConfirmation() {
					}
		@Override
		public void cleanInput() {
				}
	};
	AddEmployeeController addEmployeeController = null;
	Employee employee = null;
	@Before
	public void setUp() throws ClassNotFoundException, IOException {
		client = new Client();
		client.callLoadStaff("Nadeem");
	}
	@Test
	public void executeTest() throws ClassNotFoundException, IOException {
		addEmployeeController = new AddEmployeeController(client, addEmployeeView);

		if (client.getAllEmployeesFromTheList().size() == 0) {
			addEmployeeController.executes();
			client.callLoadPateint("Nadeem");
			assertEquals(1, client.getAllPatientsFromTheList().size());
			client.removePatient(client.getAllPatientsFromTheList().get(0).getId());
		}
	}
}
