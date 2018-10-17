package view.manager.editemployee;

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

import controller.employee.manager.EditEmployeeController;
import domain.model.staff.Employee;

public class EditEmployeeGUI extends JFrame implements EditEmployeeView {

	private JPanel contentPane;
	private JTextField txtSearchEmployeeName;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDOB;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtGender;
	private JTextField txtStartDate;
	private JButton btnSave;
	private JComboBox cmbSelectEmployeeId;
	private JButton btnSearch;

	private Employee emp;

	private EditEmployeeGUI editEmployeeGUI;

	private EditEmployeeController editEmployeeController;
	private EditEmployeeButtonHandler listener;
	private JLabel label;
	private JLabel label_1;

	public EditEmployeeGUI() {
		setTitle("Edit Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtSearchEmployeeName = new JTextField();
		txtSearchEmployeeName.setBounds(220, 30, 116, 22);
		contentPane.add(txtSearchEmployeeName);
		txtSearchEmployeeName.setColumns(10);

		// here is our cobx
		cmbSelectEmployeeId = new JComboBox();
		cmbSelectEmployeeId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}

		});

		cmbSelectEmployeeId.setBounds(220, 82, 117, 22);
		contentPane.add(cmbSelectEmployeeId);

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

		txtStartDate = new JTextField();
		txtStartDate.setBounds(220, 461, 116, 22);
		contentPane.add(txtStartDate);
		txtStartDate.setColumns(10);

		JLabel lblSearchEmployeeName = new JLabel("Search Employee Name");
		lblSearchEmployeeName.setBounds(64, 35, 146, 16);
		contentPane.add(lblSearchEmployeeName);
		// here is our btn

		btnSearch = new JButton("Search");
		btnSearch.setBounds(346, 33, 78, 22);
		contentPane.add(btnSearch);

		btnSave = new JButton("Save");
		btnSave.setBounds(334, 505, 77, 23);
		contentPane.add(btnSave);

		//

		JLabel lblSelectEmployee = new JLabel("Select Employee");
		lblSelectEmployee.setBounds(64, 86, 146, 16);
		contentPane.add(lblSelectEmployee);

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

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(64, 458, 146, 16);
		contentPane.add(lblStartDate);

	}

	public void start(EditEmployeeController controller) {
		enableRemoveButton(false);

		this.editEmployeeController = controller;
		contentPane.add(btnSearch);
		this.listener = new EditEmployeeButtonHandler(this.editEmployeeController);
		if (this.btnSearch != null) {
			btnSearch.addActionListener(listener);

		}

		// now adding the Save one -----------------------------------------

		this.editEmployeeController = controller;
		contentPane.add(btnSave);
		
		this.contentPane.add(btnSave);

		if (!(btnSave == null)) {
			btnSave.addActionListener(listener);

		}

		// ----------------------------------------------------------------------------------------------------------------
		// getting the values from the controller

		cmbSelectEmployeeId.addActionListener(listener);

		// ---------------------------------------------------------------------------------------------------------------------
		setVisible(true);

	}

	public String getSearchTxtValue() {

		String name = " ";
		if (txtSearchEmployeeName.getText() != null) {
			name = txtSearchEmployeeName.getText();
		}
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

	public String getStartDate() {
		String name = " ";
		if (txtStartDate.getText() != null) {
			name = txtStartDate.getText();
		}
		return name;
	}

	public void setComboboxValue(int[] ides) {
		for (int i = 0; i < ides.length; i++) {
			cmbSelectEmployeeId.addItem(ides[i]);
			enableRemoveButton(true);
		
			
		}
	}

	public int getSelectedValueCmbox() {

		return (int) cmbSelectEmployeeId.getSelectedItem();

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

	public void setStartDate(Date date) {

		String what = date.toString();
		// date.toString();
		txtStartDate.setText(what);
	}
	public void enableRemoveButton(boolean enable) {
		btnSave.setEnabled(enable);
	}

}