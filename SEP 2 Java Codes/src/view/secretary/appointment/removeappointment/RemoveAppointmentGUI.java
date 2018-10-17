package view.secretary.appointment.removeappointment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.appointment.removeappointment.RemoveAppointmentController;
import domain.model.patient.Appointment;

public class RemoveAppointmentGUI extends JFrame implements RemoveAppointment {
	private JPanel contentPane;
	private JTable table;
	private RemoveAppointmentController removeAppointmentController;
	private RemoveAppointmentButtonHandler listener;
	private JButton btnRemove;
	private JComboBox comboBox;
	private JButton btnLstAllAppointment;

	/**
	 * Create the frame.
	 */
	public RemoveAppointmentGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 602, 23);
		contentPane.add(panel);
		panel.setLayout(null);
		this.btnLstAllAppointment = new JButton("List All Appointments");
		btnLstAllAppointment.setBounds(0, 0, 150, 23);
		panel.add(btnLstAllAppointment);
		this.comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(100);
		comboBox.setToolTipText("");
		comboBox.setBounds(507, 3, 85, 20);
		panel.add(comboBox);
		JLabel lblSelectAppointmentId = new JLabel("Select Appointment id:");
		lblSelectAppointmentId.setBounds(284, 4, 213, 14);
		panel.add(lblSelectAppointmentId);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(5, 48, 592, 214);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setBounds(29, 151, 546, 71);
		scrollPane.setViewportView(table);
		this.btnRemove = new JButton("Remove the Selected Appointment");
		btnRemove.setBounds(299, 273, 284, 23);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnRemove);
	}

	@Override
	public void start(RemoveAppointmentController removeAppointmentController) {
		this.btnRemove.setEnabled(false);
		this.removeAppointmentController = removeAppointmentController;
		this.listener = new RemoveAppointmentButtonHandler(this.removeAppointmentController);
		if (this.btnLstAllAppointment != null) {
			btnLstAllAppointment.addActionListener(listener);
		}
		// now the next button

		btnRemove.addActionListener(listener);
		this.setVisible(true);
	}

	@Override
	public void showTable(ArrayList<Appointment> appointments) {
		String[] columnNames = { "Appointment Id", "Brief", " Time Of Appointment", "Patient Name" };
		String[][] tableArray = new String[appointments.size()][4];
		for (int i = 0; i < appointments.size(); i++) {

			String appointmentId = String.valueOf(appointments.get(i).getDateOfAppointmentId());
			String brief = appointments.get(i).getBrief();

			Date timeForAppointment = appointments.get(i).getDateOfAppointment();
			String timeForAppointmentString = null;
			if (!(timeForAppointment == null)) {
				timeForAppointmentString = timeForAppointment.toString();
			}

			String patientName = appointments.get(i).getPatientName();

			tableArray[i] = new String[] { appointmentId, brief, timeForAppointmentString, patientName };
		}
		TableModel tableModel = new DefaultTableModel(tableArray, columnNames);
		table.setModel(tableModel);
	}

	@Override
	public void setComboboxValue(int[] ides) {
		comboBox.removeAllItems();
		for (int i = 0; i < ides.length; i++) {
			comboBox.addItem(ides[i]);
		}
	}

	@Override
	public int getSelectedItemFromBox() {
		int id = 0;
		id = (int) comboBox.getSelectedItem();

		return id;
	}

	public void enableRemoveButton(boolean enable) {
		btnRemove.setEnabled(enable);
	}
}