package domain.model.staff;

import java.io.Serializable;
import java.util.Date;

public class Manager extends Employee implements Serializable {

	public Manager(int id, String firstname, String lastname, Date dob, Date startdate, String telnumber, String email,
			String gender, String username, String employeepassword) {
		super(id, firstname, lastname, dob, startdate, telnumber, email, gender, username, employeepassword);
	}

	@Override
	public String toString() {
		return "FirstName is : " + getFirstName() + "LastName is : " + getLastName() + "Dob is : " + getDob()
				+ ", StartDate is : " + getStartDate() + ", tTelNumber is : " + getTelNumber() + ", Eamil is : "
				+ getEamil() + ",Gender is : " + getGender() + " username is :" + getUserName() + "Password is : "
				+ getPassword() + "type is " + getClass().getSimpleName() + "]";
	}
}
