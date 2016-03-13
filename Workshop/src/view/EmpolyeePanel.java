package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import domain.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EmpolyeePanel extends JPanel implements ActionListener {
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField specializationTextField;
	private JTextField salaryTextField;
	private JTable employeesTable;

	private Employee employee;
	private List<Employee> employees;

	/**
	 * Create the panel.
	 */
	public EmpolyeePanel() {
		setBounds(100, 100, 800, 600);
		setLayout(null);

		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(63, 32, 99, 15);
		add(firstNameLabel);

		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(63, 62, 99, 15);
		add(lastNameLabel);

		JLabel phoneNumberLabel = new JLabel("Phone number");
		phoneNumberLabel.setBounds(63, 89, 109, 15);
		add(phoneNumberLabel);

		JLabel specializationLabel = new JLabel("Specialization");
		specializationLabel.setBounds(63, 116, 126, 15);
		add(specializationLabel);

		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setBounds(63, 143, 70, 15);
		add(salaryLabel);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(227, 28, 114, 19);
		add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(227, 58, 114, 19);
		add(lastNameTextField);
		lastNameTextField.setColumns(10);

		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(227, 85, 114, 19);
		add(phoneNumberTextField);
		phoneNumberTextField.setColumns(10);

		specializationTextField = new JTextField();
		specializationTextField.setBounds(227, 114, 114, 19);
		add(specializationTextField);
		specializationTextField.setColumns(10);

		salaryTextField = new JTextField();
		salaryTextField.setBounds(227, 141, 114, 19);
		add(salaryTextField);
		salaryTextField.setColumns(10);

		JButton addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.setBounds(84, 195, 145, 25);
		addEmployeeButton.addActionListener(this);
		add(addEmployeeButton);

		JButton deleteEmployeeButton = new JButton("Delete Employee");
		deleteEmployeeButton.setBounds(313, 195, 162, 25);
		add(deleteEmployeeButton);

		JButton btnUpdateData = new JButton("Update Data");
		btnUpdateData.setBounds(559, 195, 155, 25);
		add(btnUpdateData);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 270, 689, 216);
		add(scrollPane);

		employeesTable = new JTable();
		scrollPane.setViewportView(employeesTable);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		employee = new Employee();
		employee.setFirstName(firstNameTextField.getText());
		employee.setLastName(lastNameTextField.getText());
		employee.setPhoneNumber(phoneNumberTextField.getText());
		employee.setSpecialization(specializationTextField.getText());
		employee.setSalary(Double.parseDouble(salaryTextField.getText()));

		employee.addEmployee();
		employees = employee.showListEmployees();
		
		TableModel model = new TableModel() {
			
			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeTableModelListener(TableModelListener l) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getColumnName(int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addTableModelListener(TableModelListener l) {
				// TODO Auto-generated method stub
				
			}
		};
		employeesTable.setModel(model);
	}

}
