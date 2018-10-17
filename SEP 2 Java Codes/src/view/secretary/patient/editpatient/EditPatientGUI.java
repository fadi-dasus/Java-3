package view.secretary.patient.editpatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clients.Client;
import controller.patient.EditPatientController;
import domain.model.staff.Employee;

public class EditPatientGUI extends JFrame implements EditPatientView {

	private JPanel contentPane;
	private JTextField txtSearchPatientName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDOB;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtGender;

	private JButton btnSave;
	private JButton btnSearch;

	private JComboBox cmbSelectPatientId;

	private Employee emp;

	private Client client;
	private EditPatientController editePatientController;
	private EditPatientButtonHandler listener;

	/**
	 * Create the frame.
	 */
	public EditPatientGUI() {
		setTitle("Edit Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtSearchPatientName = new JTextField();
		txtSearchPatientName.setBounds(220, 30, 116, 22);
		contentPane.add(txtSearchPatientName);
		txtSearchPatientName.setColumns(10);

		cmbSelectPatientId = new JComboBox();
		cmbSelectPatientId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cmbSelectPatientId.setBounds(220, 82, 117, 22);
		contentPane.add(cmbSelectPatientId);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(221, 149, 116, 22);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setBounds(221, 201, 116, 22);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);

		txtDOB = new JTextField();
		txtDOB.setBounds(220, 253, 116, 22);
		contentPane.add(txtDOB);
		txtDOB.setColumns(10);

		txtTel = new JTextField();
		txtTel.setBounds(221, 305, 116, 22);
		contentPane.add(txtTel);
		txtTel.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(220, 357, 116, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtGender = new JTextField();
		txtGender.setBounds(220, 409, 116, 22);
		contentPane.add(txtGender);
		txtGender.setColumns(10);

		JLabel lblSearchPatientName = new JLabel("Search Patient Name");
		lblSearchPatientName.setBounds(64, 35, 146, 16);
		contentPane.add(lblSearchPatientName);

		JLabel lblSelectPatient = new JLabel("Select Patient");
		lblSelectPatient.setBounds(64, 86, 146, 16);
		contentPane.add(lblSelectPatient);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(64, 152, 146, 16);
		contentPane.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(64, 203, 146, 16);
		contentPane.add(lblLastName);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(64, 254, 146, 16);
		contentPane.add(lblDateOfBirth);

		JLabel lblTelephoneNo = new JLabel("Telephone no.");
		lblTelephoneNo.setBounds(64, 305, 146, 16);
		contentPane.add(lblTelephoneNo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(64, 356, 146, 16);
		contentPane.add(lblEmail);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(64, 407, 146, 16);
		contentPane.add(lblGender);

		btnSave = new JButton("Save");
		btnSave.setBounds(305, 517, 97, 25);
		contentPane.add(btnSave);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(337, 29, 97, 25);
		contentPane.add(btnSearch);
	}

	public void start(EditPatientController controller) {
		enableRemoveButton(false);
		this.editePatientController = controller;
		contentPane.add(btnSearch);
		this.listener = new EditPatientButtonHandler(this.editePatientController);
		if (this.btnSearch != null) {
			btnSearch.addActionListener(listener);

		}

		this.editePatientController = controller;
		contentPane.add(btnSave);

		this.contentPane.add(btnSave);

		if (!(btnSave == null)) {
			btnSave.addActionListener(listener);

		}

		cmbSelectPatientId.addActionListener(listener);

		setVisible(true);

	}

	public String getSearchTxtValue() {

		String name = txtSearchPatientName.getText();
		
		return name;
	}

	public String getFirstName() {
		String name = " ";
		if (txtFirstName.getText() != null) {
			name = txtFirstName.getText();
		}
		return name;

	}

	public String getLastName() {
		String name = " ";
		if (txtLastName.getText() != null) {
			name = txtLastName.getText();
		}
		return name;
	}

	public String getTel() {
		String name = " ";
		if (txtTel.getText() != null) {
			name = txtTel.getText();
		}
		return name;
	}

	public String getEmail() {

		String name = " ";
		if (txtEmail.getText() != null) {
			name = txtEmail.getText();
		}
		return name;
	}

	public String getGender() {
		String name = " ";
		if (txtGender.getText() != null) {
			name = txtGender.getText();
		}
		return name;
	}

	public String getDate() {

		String name = " ";
		if (txtDOB.getText() != null) {
			name = txtDOB.getText();
		}
		return name;

	}



	public void setComboboxValue(int[] ides) {
		for (int i = 0; i < ides.length; i++) {
			cmbSelectPatientId.addItem(ides[i]);
			enableRemoveButton(true);
		}
	}

	public int getSelectedValueCmbox() {

		return (int) cmbSelectPatientId.getSelectedItem();

	}

	public void setFirstName(String firstName) {
		txtFirstName.setText(firstName);
	}

	public void setLastName(String lastName) {
		txtLastName.setText(lastName);
	}

	public void setDOB(Date date) {
		String what = date.toString();
		// date.toString();
		txtDOB.setText(what);
	}

	public String getName() {
		return txtFirstName.getText();
	}

	public void setTel(String tel) {
		txtTel.setText(tel);
	}

	public void setEmail(String email) {
		txtEmail.setText(email);
	}

	public void setGender(String gender) {
		txtGender.setText(gender);
	}

	public void enableRemoveButton(boolean enable) {
		btnSave.setEnabled(enable);
	}

}