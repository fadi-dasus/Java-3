
package view.secretary.patient.searchpatient;

import java.util.ArrayList;

import controller.patient.SearchPatientController;
import domain.model.patient.Patient;

public interface SearchPatientView
{
   public void showTable(ArrayList<Patient> patients);

   public void start(SearchPatientController controller);

   public String getNameValue();
}
