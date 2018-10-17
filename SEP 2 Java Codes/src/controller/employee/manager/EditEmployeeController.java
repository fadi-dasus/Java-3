package controller.employee.manager;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import clients.Client;
import domain.model.staff.Employee;
import view.manager.editemployee.EditEmployeeView;
import view.manager.searchemployee.SearchEmployeeGUI;

public class EditEmployeeController {
	private Client client;

	private EditEmployeeView editEmployeeView;

	public EditEmployeeController(Client client, EditEmployeeView editEmployeeView)
			throws ClassNotFoundException, IOException {

		this.client = client;
		this.editEmployeeView = editEmployeeView;
	}

	public void executes(String what) throws RemoteException {

		switch (what) {

		case "Search":

			String name = " ";
			name = editEmployeeView.getSearchTxtValue();
			if (name.length() > 1) {
				
				name = name.substring(0, 1).toUpperCase()
						+ ((EditEmployeeView) editEmployeeView).getSearchTxtValue().substring(1).toLowerCase();
			}
			try {
				client.callLoadStaff(name);
			} catch (IOException e) {

				e.printStackTrace();
			}

			int[] ides = new int[client.getAllEmployeesFromTheList().size()];
			for (int i = 0; i < ides.length; i++) {
				ides[i] = client.getAllEmployeesFromTheList().get(i).getId();

			}

			editEmployeeView.setComboboxValue(ides);

			break;

		case "pickcmbBox":
			int id = editEmployeeView.getSelectedValueCmbox();
			Employee emp = client.getEmployeeById(id);

			editEmployeeView.setFirstName(emp.getFirstName());
			editEmployeeView.setLastName(emp.getLastName());
			editEmployeeView.setDOB(emp.getDob());
			editEmployeeView.setTel(emp.getTelNumber());
			editEmployeeView.setEmail(emp.getEmail());
			editEmployeeView.setGender(emp.getGender());
			editEmployeeView.setStartDate(emp.getStartDate());

			System.out.println("ComboBox");

			break;

		case "Save":
			int id1 = editEmployeeView.getSelectedValueCmbox();
			String firstName = editEmployeeView.getFirstName();
			String lastName = editEmployeeView.getLastName();
			String telNumber = editEmployeeView.getTel();
			String email = editEmployeeView.getEmail();
			String gender = editEmployeeView.getGender();
			String startDate = editEmployeeView.getStartDate();

			String dob = editEmployeeView.getDate();

			Employee emp2 = client.getEmployeeById(id1);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

			SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date date = null;
			try {
				date = sdf1.parse(startDate);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());

			SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date date1 = null;
			try {
				date1 = sdf2.parse(dob);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDOB = new java.sql.Date(date1.getTime());

			emp2.setFirstName(firstName);
			emp2.setLastName(lastName);
			emp2.setTelNumber(telNumber);
			emp2.setEmail(email);
			emp2.setGender(gender);
			emp2.setDob(sqlDOB);
			emp2.setStartDate(sqlStartDate);

			client.updateEmployee(emp2);

			System.out.println("Save");

		default:

			break;
		}

	}

}