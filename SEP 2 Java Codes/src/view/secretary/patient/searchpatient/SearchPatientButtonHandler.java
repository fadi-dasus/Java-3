package view.secretary.patient.searchpatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;

import controller.patient.SearchPatientController;

public class SearchPatientButtonHandler implements ActionListener
{
   private SearchPatientController searchPatientController;

   public SearchPatientButtonHandler(SearchPatientController searchPatientController)
   {
      this.searchPatientController = searchPatientController;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
	   if (!(e.getSource() instanceof JButton))
	         return;
	     
	      try
         {
            searchPatientController.executes();
         }
         catch (RemoteException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
   }

}