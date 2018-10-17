package view.manager.manageemployee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clients.Client;
import controller.employee.manager.AddEmployeeController;
import controller.employee.manager.EditEmployeeController;
import controller.employee.manager.RemoveEmlployeeController;
import controller.employee.manager.SearchEmployeeController;
import controller.patient.AddPatientController;
import view.manager.addemployee.AddEmployeeGUI;
import view.manager.editemployee.EditEmployeeGUI;
import view.manager.removeemployee.RemoveEmployeeGUI;
import view.manager.searchemployee.SearchEmployeeGUI;
import view.secretary.appointment.addappointment.AddAppointmentGUI;
import view.secretary.appointment.removeappointment.RemoveAppointmentGUI;
import view.secretary.patient.addpatient.AddPatientGUI;
import view.secretary.patient.editpatient.EditPatientGUI;
import view.secretary.patient.removepatient.RemovePatientGUI;
import view.secretary.patient.searchpatient.SearchPatientGUI;
import view.secretary.secretarymain.ManageSecretaryGUI.MyButtonListener;

import javax.swing.JButton;

public class ManageEmployeeGUI extends JFrame
{
   private JButton btnAddEmployee;
   private JButton btnEditEmployee;
   private JButton btnRemoveEmployee;
   private JButton btnSearchEmployee;
   private MyButtonListener listener;

   private JPanel contentPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
               ManageEmployeeGUI frame = new ManageEmployeeGUI();
               frame.setVisible(true);
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public ManageEmployeeGUI()
   {
      listener = new MyButtonListener();
      setTitle("Manage Employee");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      btnAddEmployee = new JButton("Add Employee");
      btnAddEmployee.setBounds(147, 30, 138, 25);
      contentPane.add(btnAddEmployee);
      btnAddEmployee.addActionListener(listener);

      btnEditEmployee = new JButton("Edit Employee");
      btnEditEmployee.setBounds(147, 85, 138, 25);
      contentPane.add(btnEditEmployee);
      btnEditEmployee.addActionListener(listener);

      btnRemoveEmployee = new JButton("Remove Employee");
      btnRemoveEmployee.setBounds(147, 140, 138, 25);
      contentPane.add(btnRemoveEmployee);
      btnRemoveEmployee.addActionListener(listener);

      btnSearchEmployee = new JButton("Search Employee");
      btnSearchEmployee.setBounds(147, 195, 138, 25);
      contentPane.add(btnSearchEmployee);
      btnSearchEmployee.addActionListener(listener);
   }

   public class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == btnAddEmployee)
         {

            Client model = new Client();
            AddEmployeeGUI view = new AddEmployeeGUI();
            view.setVisible(true);
            AddEmployeeController controller = null;
            try
            {
               controller = new AddEmployeeController(model, view);
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
         // else if (e.getSource() == btnEditEmployee) {
         // gui= new AddAppointmentGUI();
         // gui.setVisible(true);
         // }
         else if (e.getSource() == btnRemoveEmployee)
         {
            Client model = new Client();
            RemoveEmployeeGUI view = new RemoveEmployeeGUI();
            view.setVisible(true);
            RemoveEmlployeeController controller = null;
            try
            {
               controller = new RemoveEmlployeeController(model, view);
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

         else if (e.getSource() == btnSearchEmployee)
         {
            Client model = new Client();
            SearchEmployeeGUI view = new SearchEmployeeGUI();
            view.setVisible(true);
            SearchEmployeeController controller = null;
            try
            {
               controller = new SearchEmployeeController(model, view);
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

         else if (e.getSource() == btnEditEmployee)
         {

            Client model = new Client();
            EditEmployeeGUI view = new EditEmployeeGUI();
            EditEmployeeController controller = null;
            try
            {
               controller = new EditEmployeeController(
                     model, view);
            }
            catch (ClassNotFoundException | IOException e1)
            {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            view.start(controller);

            view.setVisible(true);

         }

      }

   }

}
