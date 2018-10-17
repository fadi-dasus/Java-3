package domain.mediator.staff;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import domain.model.staff.Employee;
import domain.model.staff.EmployeeFactory;
import domain.model.staff.EmployeeList;
import domain.model.staff.Type;

public class ServerStaffClinicModelManager extends UnicastRemoteObject implements RemoteStaffClinicModel {

	private EmployeeList list;
	private StaffPersistence persistence;
	private Employee employee;

	public ServerStaffClinicModelManager() throws IOException, ClassNotFoundException {
		this.persistence = new StaffDatabase();

		Registry reg = LocateRegistry.createRegistry(1099);
		reg.rebind("StaffServer", this);
	
	}

	public void LoadFromDB(String name) throws IOException {
		this.list = persistence.loadEmployeesByName(name);
	}

	public String[] reachType() {
		return Type.enumsToStringArray();
	}

	@Override
	public void addEmployee(String[] employeeData) {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

		Date dob = null;
		try {
			if (employeeData[2] != null && !employeeData[2].isEmpty()) {
				dob = format.parse(employeeData[2]);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date startDate = null;
		try {
			if (employeeData[3] != null && !employeeData[3].isEmpty()) {
				startDate = format.parse(employeeData[3]);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		int id = 0;
		String firstName = employeeData[0];
		String lastName = employeeData[1];

		String telNumber = employeeData[4];
		String email = employeeData[5];
		String gender = employeeData[6];
		Type employeeType = Type.valueOf(employeeData[7]);

		String username = employeeData[0].toString();
		if (username != null && username.length() > 1) {
			username = username.substring(0, 1).toLowerCase() + employeeData[1].toString().toLowerCase();
		}
		String password = "123456";

		employee = EmployeeFactory.create(id, firstName, lastName, dob, startDate, telNumber, email, gender,
				employeeType, username, password);

		try {
			persistence.save(employee);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Employee> getEmployeeByname(String name) {

		Employee employee = list.getEmployeeByName(name);

		ArrayList<Employee> employees = new ArrayList<Employee>();
		if (employee != null) {
			employees.add(employee);
		}

		return employees;
	}

	public ArrayList<Employee> getAllEmployeesFromTheList() {
		return list.getAllEmployees();

	}

	@Override
	public void removePatientById(int id) {
		Employee employee = list.getEmployeeById(id);
		if (employee != null) {
			list.removeEmployee(employee);
			try {
				persistence.remove(employee);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Employee getEmployeeById(int id) {
		return list.getEmployeeById(id);
	}

	public void updateEmployee(Employee employee) {

		try {
			persistence.updateEmployee(employee);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
