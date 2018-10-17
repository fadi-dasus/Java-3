package view.secretary.patient.searchpatient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.patient.SearchPatientController;
import domain.model.patient.Patient;

public class SearchPatientGUI extends JFrame implements SearchPatientView {
	private SearchPatientController searchPatientController;
	private JPanel contentPane;
	private JTextField textName;
	private JTable table;

	private SearchPatientButtonHandler listener;

	private JScrollPane scrollPane;
	private JPanel panel;

	public SearchPatientGUI() {
		setTitle("Search Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(28, 77, 396, 152);

		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lbl = new JLabel("Patient Name");
		panel.add(lbl);

		textName = new JTextField();
		panel.add(textName);
		textName.setColumns(10);

	}

	@Override
	public void start(SearchPatientController controller) {
		JButton buttonSearch = new JButton("Search");
		panel.add(buttonSearch);
		this.searchPatientController = controller;
		this.listener = new SearchPatientButtonHandler(this.searchPatientController);
		if (!(buttonSearch == null)) {

			buttonSearch.addActionListener(listener);
		}
		this.setVisible(true);
	}

	@Override
	public String getNameValue() {
		String name = textName.getText();
		if (name.length() > 0) {
			return name;
		} else
			return " ";
	}

	@Override
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

		table.setModel(tableModel);

	}

}
