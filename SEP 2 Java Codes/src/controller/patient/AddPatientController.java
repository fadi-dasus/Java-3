package controller.patient;

import java.io.IOException;
import java.rmi.RemoteException;

import clients.Client;
import view.secretary.patient.addpatient.AddPatientView;

public class AddPatientController
{
   private Client client;
   private AddPatientView addPatientView;

   public AddPatientController(Client client, AddPatientView addPatientView)
         throws ClassNotFoundException, IOException
   {
      this.client = client;
      this.addPatientView = addPatientView;
   }

   public void executes() throws RemoteException
   {
      String[] data = addPatientView.getTextFieldValues();
      
      boolean error = false;
      
      for (int i = 0; i < data.length; i++)
      {
         if (data[i].isEmpty())
         {
            addPatientView.showError();
            error = true;
            break;
         }
      }
      
      if (error == false)
      {
         client.addPatient(data);
         addPatientView.showConfirmation();
         addPatientView.cleanInput();
      }

   }

}
