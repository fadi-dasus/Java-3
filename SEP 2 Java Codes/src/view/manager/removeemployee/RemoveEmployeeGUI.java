package view.manager.removeemployee;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.employee.manager.RemoveEmlployeeController;
import domain.model.staff.Employee;

public class RemoveEmployeeGUI extends JFrame implements RemoveEmployeeView {
	private JComboBox cmbSelectEmployee;
	private JPanel contentPane;
	private JTextField txtSearchEmployeeName;
	private JTable tblRemove;
	private RemoveEmlployeeController removeEmlployeeController;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnRemoveEmployee;
	private JButton btnSearch;

	private JTextField txtSearch;
	private JPanel panel_2;
	private RemoveEmployeeButtonHandler listener;

	public RemoveEmployeeGUI() {
		setTitle("Remove Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 706, 45);

		JLabel lblSeach = new JLabel("Search Employee Name");
		panel.add(lblSeach);

		txtSearchEmployeeName = new JTextField();
		panel.add(txtSearchEmployeeName);
		txtSearchEmployeeName.setColumns(10);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		panel_2 = new JPanel();
		contentPane.add(panel_2);

		JLabel lblSearchEmployee = new JLabel("Search Employee");
		panel_2.add(lblSearchEmployee);

		txtSearch = new JTextField();
		panel_2.add(txtSearch);
		txtSearch.setColumns(10);

		this.panel_1 = new JPanel();
		contentPane.add(panel_1);

		JLabel lblSelect = new JLabel("Select Employee Id");
		panel_1.add(lblSelect);

		cmbSelectEmployee = new JComboBox();
		panel_1.add(cmbSelectEmployee);

		JScrollPane scrollPane = new JScrollPane();

		tblRemove = new JTable();
		tblRemove.setBounds(29, 151, 546, 71);

		scrollPane.setViewportView(tblRemove);
		contentPane.add(scrollPane);

	}

	public void start(RemoveEmlployeeController removeEmlployeeController) {

		this.btnSearch = new JButton("Search");

		panel_2.add(btnSearch);
		this.removeEmlployeeController = removeEmlployeeController;
		this.listener = new RemoveEmployeeButtonHandler(this.removeEmlployeeController);
		if (!(btnSearch == null)) {
			btnSearch.addActionListener(listener);

		}

		// now adding the remove one -----------------------------------------
		this.btnRemoveEmployee = new JButton("Remove");
		btnRemoveEmployee.setEnabled(false);
		this.panel_1.add(btnRemoveEmployee);

		if (!(btnRemoveEmployee == null)) {
			btnRemoveEmployee.addActionListener(listener);

		}

		this.setVisible(true);
	}

	public void enableRemoveButton(boolean enable) {
		btnRemoveEmployee.setEnabled(enable);
	}

	public String getSearchTxtValue() {
		String name = txtSearch.getText();
		return name;
	}

	public void showTable(ArrayList<Employee> employees) {

		String[] columnNames = { "id", "First Name", "Last Name", "dob", "Start Date", "Tel Number", "Eamil", "Gender",
				"Employee Type", "Username", "Password" };

		String[][] tableArray = new String[employees.size()][10];

		for (int i = 0; i < employees.size(); i++) {

			String id = String.valueOf(employees.get(i).getId());

			Date dob = employees.get(i).getDob();
			String dateDob = null;
			if (!(dob == null)) {
				dateDob = dob.toString();
			}

			Date startDate = employees.get(i).getStartDate();
			String dateStartDate = null;
			if (!(startDate == null)) {
				dateStartDate = startDate.toString();
			}

			tableArray[i] = new String[] { id, employees.get(i).getFirstName(), employees.get(i).getLastName(), dateDob,
					dateStartDate, employees.get(i).getTelNumber(), employees.get(i).getEamil(),
					employees.get(i).getGender(), employees.get(i).getClass().getSimpleName(),
					employees.get(i).getUserName(), employees.get(i).getPassword() };

		}

		TableModel tableModel = new DefaultTableModel(tableArray, columnNames);

		tblRemove.setModel(tableModel);

	}

	public void setComboboxValue(int[] ides) {
		for (int i = 0; i < ides.length; i++) {
			cmbSelectEmployee.addItem(ides[i]);
		}
	}

	public int getSelectedItemFromBox() {
		int id = 0;
		id = (int) cmbSelectEmployee.getSelectedItem();

		return id;
	}

}
