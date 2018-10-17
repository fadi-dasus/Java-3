package view.secretary.appointment.removeappointment;

import java.util.ArrayList;

import controller.appointment.removeappointment.RemoveAppointmentController;
import domain.model.patient.Appointment;
import domain.model.patient.AppointmentList;

public interface RemoveAppointment {

	public void setComboboxValue(int[] ides);

	public void showTable(ArrayList<Appointment> appointments);

	void start(RemoveAppointmentController removeAppointmentController);

	public int getSelectedItemFromBox();

	public void enableRemoveButton(boolean enable);

}