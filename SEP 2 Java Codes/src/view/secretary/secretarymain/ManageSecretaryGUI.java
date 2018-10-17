package view.secretary.secretarymain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clients.Client;
import controller.appointment.addappointment.AddApointmnentController;
import controller.appointment.removeappointment.RemoveAppointmentController;
import controller.patient.AddPatientController;
import controller.patient.EditPatientController;
import controller.patient.RemovePatientController;
import controller.patient.SearchPatientController;
import view.secretary.appointment.addappointment.AddAppointmentGUI;
import view.secretary.appointment.removeappointment.RemoveAppointmentGUI;
import view.secretary.patient.addpatient.AddPatientGUI;
import view.secretary.patient.editpatient.EditPatientGUI;
import view.secretary.patient.removepatient.RemovePatientGUI;
import view.secretary.patient.searchpatient.SearchPatientGUI;

public class ManageSecretaryGUI extends JFrame
{

   private JPanel contentPane;
   private JButton btnAddPatient;
   private JButton btnEditPatient;
   private JButton btnRemovePatient;
   private JButton btnSearchPatient;
   private MyButtonListener listener;
   private JButton btnAddAppointment;
   private JButton btnEditAppointment;
   private JButton btnRemoveAppointment;
   private JButton btnSearchAppointment;
   private JButton btnRequestMedicineRenewed;
   private JButton btnListAppointment;

   /**
    * Create the frame.
    */
   public ManageSecretaryGUI()
   {
      listener = new MyButtonListener();
      setTitle("Secretary Main");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 620, 350);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      btnAddPatient = new JButton("Add Patient");
      btnAddPatient.setBounds(87, 30, 162, 25);
      contentPane.add(btnAddPatient);
      btnAddPatient.addActionListener(listener);

      btnAddAppointment = new JButton("Add Appointment");
      btnAddAppointment.setBounds(347, 30, 162, 25);
      contentPane.add(btnAddAppointment);
      btnAddAppointment.addActionListener(listener);

      btnEditPatient = new JButton("Edit Patient");
      btnEditPatient.setBounds(87, 85, 162, 25);
      contentPane.add(btnEditPatient);
      btnEditPatient.addActionListener(listener);

      btnEditAppointment = new JButton("Edit Appointment");
      btnEditAppointment.setBounds(347, 85, 162, 25);
      contentPane.add(btnEditAppointment);
      btnEditAppointment.addActionListener(listener);

      btnRemovePatient = new JButton("Remove Patient");
      btnRemovePatient.setBounds(87, 140, 162, 25);
      contentPane.add(btnRemovePatient);
      btnRemovePatient.addActionListener(listener);

      btnRemoveAppointment = new JButton("Remove Appointment");
      btnRemoveAppointment.setBounds(347, 140, 162, 25);
      contentPane.add(btnRemoveAppointment);
      btnRemoveAppointment.addActionListener(listener);

      btnSearchPatient = new JButton("Search Patient");
      btnSearchPatient.setBounds(87, 195, 162, 25);
      contentPane.add(btnSearchPatient);
      btnSearchPatient.addActionListener(listener);

      btnSearchAppointment = new JButton("Search Appointment");
      btnSearchAppointment.setBounds(347, 195, 162, 25);
      contentPane.add(btnSearchAppointment);
      btnSearchAppointment.addActionListener(listener);

      btnRequestMedicineRenewed = new JButton("Renew Medicine");
      btnRequestMedicineRenewed.setBounds(87, 250, 162, 25);
      contentPane.add(btnRequestMedicineRenewed);
      btnRequestMedicineRenewed.addActionListener(listener);

      btnListAppointment = new JButton("List Of Appointments");
      btnListAppointment.setBounds(347, 250, 162, 25);
      contentPane.add(btnListAppointment);
      btnListAppointment.addActionListener(listener);

   }

   public class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == btnAddPatient)
         {

            Client model = new Client();
            AddPatientGUI view = new AddPatientGUI();
            view.setVisible(true);
            AddPatientController controller = null;
            try
            {
               controller = new AddPatientController(model, view);
            }
            catch (ClassNotFoundException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            catch (IOException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            view.start(controller);

         }
         else if (e.getSource() == btnAddAppointment)
         {

            Client model = new Client();
            AddAppointmentGUI view = new AddAppointmentGUI();
            AddApointmnentController controller = null;
            try
            {
               controller = new AddApointmnentController(model, view);
            }
            catch (ClassNotFoundException | IOException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            view.start(controller);

            view.setVisible(true);
         }
         else if (e.getSource() == btnEditAppointment)
         {
            RemoveAppointmentGUI  gui = new RemoveAppointmentGUI();
            // gui.setVisible(true);
         }
         else if (e.getSource() == btnRemovePatient)
         {

            Client model = new Client();
            RemovePatientGUI view = new RemovePatientGUI();
            RemovePatientController controller = null;
            try
            {
               controller = new RemovePatientController(model, view);
            }
            catch (ClassNotFoundException | IOException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            view.start(controller);
            view.setVisible(true);
         }
         else if (e.getSource() == btnRemoveAppointment)
         {
            Client model = new Client();
            RemoveAppointmentGUI view = new RemoveAppointmentGUI();
            RemoveAppointmentController controller = new RemoveAppointmentController(
                  model, view);
            view.start(controller);
            view.setVisible(true);
         }
         else if (e.getSource() == btnSearchPatient)
         {

            Client client = new Client();
            SearchPatientGUI view = new SearchPatientGUI();
            SearchPatientController controller = null;
            try
            {
               controller = new SearchPatientController(client, view);
            }
            catch (ClassNotFoundException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            catch (IOException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            view.start(controller);

            view.setVisible(true);
         }
         else if (e.getSource() == btnEditPatient)
         {

            Client model = new Client();    
            EditPatientGUI view = new EditPatientGUI();
            EditPatientController conto = null;
            try
            {
               conto = new EditPatientController(model,view);
            }
            catch (ClassNotFoundException | IOException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            view.start(conto);
            view.setVisible(true);
      }

      }}
}
