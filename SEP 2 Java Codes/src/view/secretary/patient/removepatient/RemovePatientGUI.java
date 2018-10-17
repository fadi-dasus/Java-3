package view.secretary.patient.removepatient;

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

import controller.patient.RemovePatientController;
import domain.model.patient.Patient;

public class RemovePatientGUI extends JFrame implements RemovePatientView {
	private JComboBox cmbSelectPatient;
	private JPanel contentPane;
	private JTextField txtSearchPatientName;
	private JTable tblRemove;
	private RemovePatientController removePatientController;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnRemovePatient;
	private JButton btnSearch;

	private JTextField txtSearch;
	private JPanel panel_2;
	private RemovePatientButtonHandler listener;

	public RemovePatientGUI() {
		setTitle("Remove Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 706, 45);

		JLabel lblSearch = new JLabel("Search Patient Name");
		panel.add(lblSearch);

		txtSearchPatientName = new JTextField();
		panel.add(txtSearchPatientName);
		txtSearchPatientName.setColumns(10);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		panel_2 = new JPanel();
		contentPane.add(panel_2);

		JLabel lblSearchPatient = new JLabel("Search Patient");
		panel_2.add(lblSearchPatient);

		txtSearch = new JTextField();
		panel_2.add(txtSearch);
		txtSearch.setColumns(10);

		this.panel_1 = new JPanel();
		contentPane.add(panel_1);

		JLabel lblSelect = new JLabel("Select Employee Id");
		panel_1.add(lblSelect);

		cmbSelectPatient = new JComboBox();
		panel_1.add(cmbSelectPatient);

		JScrollPane scrollPane = new JScrollPane();

		tblRemove = new JTable();
		tblRemove.setBounds(29, 151, 546, 71);

		scrollPane.setViewportView(tblRemove);
		contentPane.add(scrollPane);
	}

	public void start(RemovePatientController removePatientController) {

		this.btnSearch = new JButton("Search");

		panel_2.add(btnSearch);
		this.removePatientController = removePatientController;
		this.listener = new RemovePatientButtonHandler(this.removePatientController);
		if (!(btnSearch == null)) {
			btnSearch.addActionListener(listener);

		}

		this.btnRemovePatient = new JButton("Remove");
		btnRemovePatient.setEnabled(false);
		this.panel_1.add(btnRemovePatient);

		if (!(btnRemovePatient == null)) {
			btnRemovePatient.addActionListener(listener);

		}

		this.setVisible(true);
	}

	public void enableRemoveButton(boolean enable) {
		btnRemovePatient.setEnabled(enable);
	}

	public void showTable(ArrayList<Patient> patients) {

		String[] columnNames = { "id", "First Name", "Last Name", "dob", "Tel Number", "Eamil", "Gender" };

		String[][] tableArray = new String[patients.size()][10];

		for (int i = 0; i < patients.size(); i++) {

			String id = String.valueOf(patients.get(i).getId());

			Date dob = patients.get(i).getDob();
			String dateDob = null;
			if (!(dob == null)) {
				dateDob = dob.toString();
			}

			tableArray[i] = new String[] { id, patients.get(i).getFirstName(), patients.get(i).getLastName(), dateDob,
					patients.get(i).getTelNumber(), patients.get(i).getEmail(), patients.get(i).getGender() };

		}

		TableModel tableModel = new DefaultTableModel(tableArray, columnNames);

		tblRemove.setModel(tableModel);

	}

	public void setComboboxValue(int[] ides) {
		for (int i = 0; i < ides.length; i++) {
			cmbSelectPatient.addItem(ides[i]);
		}
	}

	public int getSelectedItemFromBox() {
		int id = 0;
		id = (int) cmbSelectPatient.getSelectedItem();

		return id;
	}

	@Override
	public String getSearchTxtValue() {
		String name = txtSearch.getText();
		return name;
	}

}