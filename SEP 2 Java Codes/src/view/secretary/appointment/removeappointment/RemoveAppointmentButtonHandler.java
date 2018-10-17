package view.secretary.appointment.removeappointment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;

import controller.appointment.removeappointment.RemoveAppointmentController;

public class RemoveAppointmentButtonHandler implements ActionListener {
    private RemoveAppointmentController removeAppointmentController;

    public RemoveAppointmentButtonHandler(RemoveAppointmentController removeAppointmentController) {
        
        this.removeAppointmentController = removeAppointmentController;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!(e.getSource() instanceof JButton))
             return;
        if (((JButton) e.getSource()).getText().startsWith("List All Appointments")) {
            System.out.println(" Hi I'am Add button");
            try
            {
               removeAppointmentController.executeGetAllAppointments();
            }
            catch (RemoteException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }}
        
         if (((JButton) e.getSource()).getText().startsWith("Remove the Selected Appointment")) {
                     try
                     {
                        removeAppointmentController.executeRemoveAppointment();
                     }
                     catch (RemoteException e1)
                     {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                     }
                     System.out.println(" Hi I'am remove button");
                     }

    }

}