package view.secretary.appointment.addappointment;

import java.util.ArrayList;
import java.util.Date;

import controller.appointment.addappointment.AddApointmnentController;
import domain.model.patient.Patient;

public interface AddAppointmentView {
	public void start(AddApointmnentController addApointmnentController);

	public String getSearchTxtValue();

	public void showTable(ArrayList<Patient> patients);

	public int getSelectedItemFromBox();

	public void setComboboxValue(int[] ides);

	public int getSelectedPatientId();

	public String getTextAreaValue();

	public Date getSelectedDate();

	public void showConfirmation();

}