package view.secretary.patient.addpatient;

import controller.patient.AddPatientController;

public interface AddPatientView
{
   public void start(AddPatientController controller);

   public String[] getTextFieldValues();

   public void showError();

   public void showConfirmation();

   public void cleanInput();
}
