package domain.mediator.patient;
import java.io.IOException;

import domain.model.patient.Patient;
import domain.model.patient.PatientList;

public interface PatientPersistence
{
   public PatientList loadPatietByName(String name) throws IOException;
   public void savePatient(Patient patient) throws IOException;
   public void removePatient(Patient patient) throws IOException;
   public void updatePatient(Patient patien) throws IOException;
}
