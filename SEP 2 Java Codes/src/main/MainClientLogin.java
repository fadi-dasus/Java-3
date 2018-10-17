package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.mediator.staff.StaffDatabase;
import domain.model.staff.Doctor;
import domain.model.staff.Employee;
import domain.model.staff.Manager;
import domain.model.staff.Secretary;
import view.manager.manageemployee.ManageEmployeeGUI;
import view.secretary.secretarymain.ManageSecretaryGUI;

public class MainClientLogin extends JFrame
{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentPane;
   private JTextField txtUsername;
   private JPasswordField txtPassword;
   private JButton btnLogin;
   private MyButtonListener listener;

   private ArrayList<Employee> list;
   private StaffDatabase persistence;
   private Employee employee;

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
               MainClientLogin frame = new MainClientLogin();
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
    * 
    * @throws ClassNotFoundException
    * @throws IOException
    */
   public MainClientLogin() throws ClassNotFoundException, IOException
   {

      this.persistence = new StaffDatabase();
      this.list = persistence.loadLogIn();
      listener = new MyButtonListener();
      setTitle("Login");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      txtUsername = new JTextField();
      txtUsername.setBounds(210, 48, 137, 22);
      contentPane.add(txtUsername);
      txtUsername.setColumns(10);

      JLabel lblUsername = new JLabel("Username");
      lblUsername.setBounds(82, 51, 83, 16);
      contentPane.add(lblUsername);

      JLabel lblPassword = new JLabel("Password");
      lblPassword.setBounds(82, 107, 83, 16);
      contentPane.add(lblPassword);

      txtPassword = new JPasswordField();
      txtPassword.setBounds(210, 104, 137, 22);
      contentPane.add(txtPassword);

      btnLogin = new JButton("Login");
      btnLogin.setBounds(289, 201, 97, 25);
      contentPane.add(btnLogin);
      btnLogin.addActionListener(listener);
   }

   private class MyButtonListener implements ActionListener
   {

      public void actionPerformed(ActionEvent e)
      {

         String guiUsername = txtUsername.getText();
         String guiPassword = txtPassword.getText();

         String dbUsername = "";
         String dbPassword = "";
         boolean flag = false;

         for (int i = 0; i < list.size(); i++)
         {
            employee = list.get(i);
            dbUsername = list.get(i).getUserName();
            dbPassword = list.get(i).getPassword();

            if (guiUsername.equals(dbUsername)
                  && guiPassword.equals(dbPassword))
            {
               if (employee instanceof Doctor)
               {
                  flag = true;
                  break;
               }
               else if (employee instanceof Manager)
               {

                  ManageEmployeeGUI gui = new ManageEmployeeGUI();
                  gui.setVisible(true);
                  JOptionPane.showMessageDialog(rootPane,
                        "You are logged in as a manager",
                        "Welcom " + dbUsername, 1);
                  setVisible(false);

                  flag = true;

                  break;

               }
               else if (employee instanceof Secretary)
               {

                  ManageSecretaryGUI gui = new ManageSecretaryGUI();
                  gui.setVisible(true);
                  JOptionPane.showMessageDialog(rootPane,
                        "You are logged in as a secretary",
                        "Welcom " + dbUsername, 1);
                  setVisible(false);

                  flag = true;
                  break;
               }

            }

         }
         if (flag == false)
         {
            JOptionPane.showMessageDialog(rootPane,
                  "Invalid Username or Password ", "Authentication failed",
                  JOptionPane.ERROR_MESSAGE);
         }

      }
   }
}