package domain.model.staff;

import java.util.Date;

public class EmployeeFactory {

	public static Employee create(int id, String firstName, String lastName, Date dob, Date startDate, String telNumber,
			String email, String gender, Type employeeType, String userName, String password) {
		Employee employee = null;
		if (employeeType.equals(Type.Doctor)) {
			employee = new Doctor(id, firstName, lastName, dob, startDate, telNumber, email, gender, userName,
					password);

		} else if (employeeType.equals(Type.Manager)) {
			employee = new Manager(id, firstName, lastName, dob, startDate, telNumber, email, gender, userName,
					password);

		} else if (employeeType.equals(Type.Secretary)) {
			employee = new Secretary(id, firstName, lastName, dob, startDate, telNumber, email, gender, userName,
					password);
		}

		return employee;

	}

}
