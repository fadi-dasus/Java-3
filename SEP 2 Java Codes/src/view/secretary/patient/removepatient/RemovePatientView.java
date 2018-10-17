package view.secretary.patient.removepatient;

import java.util.ArrayList;

import controller.patient.RemovePatientController;
import domain.model.patient.Patient;

public interface RemovePatientView {

	public void showTable(ArrayList<Patient> patients);

	public void start(RemovePatientController removePatientController);

	public String getSearchTxtValue();
	public void enableRemoveButton(boolean enable);
	public void setComboboxValue(int[] ides);
	public int getSelectedItemFromBox();
}
