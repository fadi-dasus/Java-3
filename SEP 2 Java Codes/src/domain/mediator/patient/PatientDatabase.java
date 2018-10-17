package domain.mediator.patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import domain.model.patient.Patient;
import domain.model.patient.PatientList;
import utility.persistence.MyDatabase;

public class PatientDatabase implements PatientPersistence {

	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

	private static final String USER = "postgres";
	private static final String PASSWORD = "0940";

	public PatientDatabase() throws ClassNotFoundException {
		this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
	}

	@Override
	public PatientList loadPatietByName(String name) throws IOException {
		String sql = "Select * from \"Clinic\".patient WHERE firstname = '" + name + "';";

		ArrayList<Object[]> results;
		PatientList patients = new PatientList();
		int id = 0;
		String firstName = " ", lastName = " ";
		Date dob;
		String telNumber = " ", email = " ";
		String gender = " ";
		try {
			results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				id = Integer.parseInt(row[0].toString());
				firstName = row[1].toString().substring(0, 1).toUpperCase()
						+ row[1].toString().substring(1).toLowerCase();
				lastName = row[2].toString();
				dob = (Date) row[3];
				telNumber = row[4].toString();
				email = row[5].toString();
				gender = row[6].toString();

				Patient patient = new Patient(id, firstName, lastName, dob, telNumber, email, gender);
				patients.addPatient(patient);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patients;
	}

	@Override
	public void savePatient(Patient patient) throws IOException {
		{
			java.sql.Date sqlDate = null;
			if(patient.getDob() != null) {
			   sqlDate= new java.sql.Date(patient.getDob().getTime());
			}

			String firstName = patient.getFirstName();
			if(firstName != null && firstName.length()>1) {
			   firstName =  firstName.substring(0, 1).toUpperCase()
	               + patient.getFirstName().substring(1);
			}
			     

			try {
				String sql = "INSERT INTO \"Clinic\".patient (firstname, lastname, dob, telnumber,email, gender)"
						+ "VALUES (? , ? , ? , ? , ? , ?);";
				db.update(sql, firstName, patient.getLastName(), sqlDate, patient.getTelNumber(), patient.getEmail(),
						patient.getGender());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void removePatient(Patient patient) throws IOException {
		{
			int id = patient.getId();

			try {

				String sql = "DELETE FROM \"Clinic\".patient WHERE patientid = ?;";
				db.update(sql, id);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

   @Override
   public void updatePatient(Patient patient) throws IOException
   {
      try
      {

         String sql = "UPDATE \"Clinic\".patient  SET firstname = ? , lastname = ?, dob = ?,  telnumber = ?, email = ?, gender = ?   where patientid = '" + patient.getId() + "';";
        
         db.update(sql, patient.getFirstName(), patient.getLastName(), patient.getDob(), patient.getTelNumber(), patient.getEmail(), patient.getGender());

      }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
      
   }

}
