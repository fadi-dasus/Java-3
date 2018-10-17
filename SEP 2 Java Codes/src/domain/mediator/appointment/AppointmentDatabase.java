package domain.mediator.appointment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import domain.model.patient.Appointment;
import domain.model.patient.AppointmentList;
import utility.persistence.MyDatabase;

public class AppointmentDatabase implements AppointmentPersistance {

	private MyDatabase db;
	private final String DRIVER = "org.postgresql.Driver";
	private final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private final String USER = "postgres";
	private final String PASSWORD = "0940";

	public AppointmentDatabase() throws ClassNotFoundException {
		this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
	}

	@Override
	public AppointmentList loadFreeAppointments() {
		String sql = " select * from \"Clinic\".datetime where datetimeid not in( select datetimeofappointmentid from \"Clinic\".appointment);";

		AppointmentList appointmentList = new AppointmentList();

		ArrayList<Object[]> results;

		try {
			results = db.query(sql);
			System.out.println(results.size());
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				int timeid = (int) row[0];
				Date date = (Date) row[1];

				Appointment appointment = new Appointment(date, timeid);

				appointmentList.addAppointment(appointment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return appointmentList;
	}

	@Override
	public void save(Appointment appointment) {

		// java.sql.Date sqlDate = new
		// java.sql.Date(appointment.getDateOfAppointment().getTime());

		int patienID = appointment.getPatient();
		String brief = appointment.getBrief();
		int timeId = appointment.getDateOfAppointmentId();

		try {
			String sql = "INSERT INTO \"Clinic\".appointment (patientid, datetimeofappointmentid,brief)"
					+ "VALUES (?,?,?);";
			db.update(sql, patienID, timeId, brief);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {
		String sql = "delete FROM \"Clinic\".appointment WHERE appointmentid = ?;";
		try {
			db.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Appointment> loadAllTheBookedAppointment() {
		String sql = "SELECT appointment.appointmentid, appointment.brief, datetime.datetime, patient.firstname FROM (( \"Clinic\".appointment INNER JOIN  \"Clinic\".patient ON appointment.patientid = patient.patientid) INNER JOIN  \"Clinic\".datetime ON appointment.datetimeofappointmentid = datetime.datetimeid);";
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();

		ArrayList<Object[]> results;

		try {
			results = db.query(sql);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				Date dateOfAppointment = (Date) row[2];
				String patientName = row[3].toString();
				String brief = row[1].toString();
				int appointmentId = (int) row[0];

				Appointment appointment = new Appointment(patientName, dateOfAppointment, brief, appointmentId);

				appointments.add(appointment);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return appointments;
	}

}