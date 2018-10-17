package view.secretary.patient.addpatient;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.patient.AddPatientController;

public class AddPatientGUI extends JFrame implements AddPatientView

{

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDOB;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtGender;
	private JButton btnAdd;

	private AddPatientController addPatientController;
	private AddPatientButtonHandler listener;

	public AddPatientGUI() {
		setTitle("Add Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(236, 73, 116, 22);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setBounds(236, 120, 116, 22);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);

		txtDOB = new JTextField();
		txtDOB.setBounds(236, 167, 116, 22);
		contentPane.add(txtDOB);
		txtDOB.setColumns(10);

		txtTel = new JTextField();
		txtTel.setBounds(236, 214, 116, 22);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(236, 261, 116, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtGender = new JTextField();
		txtGender.setBounds(236, 308, 116, 22);
		contentPane.add(txtGender);
		txtGender.setColumns(10);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(62, 72, 162, 16);
		contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(62, 118, 162, 16);
		contentPane.add(lblLastName);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(62, 164, 162, 16);
		contentPane.add(lblDateOfBirth);

		JLabel lblTelephoneNo = new JLabel("Telephone no.");
		lblTelephoneNo.setBounds(62, 210, 162, 16);
		contentPane.add(lblTelephoneNo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(62, 256, 162, 16);
		contentPane.add(lblEmail);

		JLabel lblGener = new JLabel("Gender");
		lblGener.setBounds(62, 302, 162, 16);
		contentPane.add(lblGener);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(323, 415, 97, 25);
		contentPane.add(btnAdd);
	}

	@Override
	public void start(AddPatientController controller) {

		this.addPatientController = controller;
		this.listener = new AddPatientButtonHandler(this.addPatientController);
		if (!(btnAdd == null)) {

			btnAdd.addActionListener(listener);
		}

		setVisible(true);

	}

	@Override
	public String[] getTextFieldValues() {
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String dob = txtDOB.getText();
		String tlf = txtTel.getText();
		String email = txtEmail.getText();
		String gender = txtGender.getText();
		String[] patientData = { firstName, lastName, dob, tlf, email, gender };

		return patientData;
	}

	public void showError() {

		JOptionPane.showMessageDialog(contentPane, "please fill all the fields before adding.");
	}

	public void showConfirmation() {

		JOptionPane.showMessageDialog(contentPane, "a new  patient has been added succefully.");
	}

	public void cleanInput() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtDOB.setText("");
		txtTel.setText("");
		txtEmail.setText("");
		txtGender.setText("");

	}

}
