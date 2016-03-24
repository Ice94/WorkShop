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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmpolyeePanel extends JPanel implements ActionListener {
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField specializationTextField;
	private JTextField salaryTextField;
	private JTable employeesTable;
	private JScrollPane scrollPane;
	private JButton addEmployeeButton;
	private JButton deleteEmployeeButton;
	private JButton updateDataButton;

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

		addEmployeeButton = new JButton("Add Employee");
		addEmployeeButton.setBounds(84, 195, 145, 25);
		addEmployeeButton.addActionListener(this);
		add(addEmployeeButton);

		deleteEmployeeButton = new JButton("Delete Employee");
		deleteEmployeeButton.setBounds(313, 195, 162, 25);
		deleteEmployeeButton.addActionListener(this);
		add(deleteEmployeeButton);

		updateDataButton = new JButton("Update Data");
		updateDataButton.setBounds(559, 195, 155, 25);
		updateDataButton.addActionListener(this);
		add(updateDataButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 270, 689, 216);

		add(scrollPane);
		employee = new Employee();
		refreshData();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();

		if (button == addEmployeeButton) {
			setEmpolyeeData();
			employee.addEmployee();
		}
		if (button == deleteEmployeeButton) {
			long id = (long) employeesTable.getValueAt(employeesTable.getSelectedRow(),
					employeesTable.getSelectedColumn());
			employee.deleteEmployee(id);
		}
		if (button == updateDataButton) {
			long id = (long) employeesTable.getValueAt(employeesTable.getSelectedRow(),
					employeesTable.getSelectedColumn());
			setEmpolyeeData();
			employee.updateData(employee,id);
		}

		refreshData();
	}

	public void refreshData() {
		employees = employee.getEmployees();
		TableModel model = new EmployeeTableModel(employees);
		employeesTable = new JTable(model);
		employeesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTextField();
			}
		});
		scrollPane.setViewportView(employeesTable);
	}
	public void setTextField(){
		firstNameTextField.setText(employeesTable.getValueAt(employeesTable.getSelectedRow(), 1).toString());
		lastNameTextField.setText(employeesTable.getValueAt(employeesTable.getSelectedRow(), 2).toString());
		phoneNumberTextField.setText(employeesTable.getValueAt(employeesTable.getSelectedRow(), 3).toString());
		salaryTextField.setText(employeesTable.getValueAt(employeesTable.getSelectedRow(), 4).toString()); 
		specializationTextField.setText(employeesTable.getValueAt(employeesTable.getSelectedRow(), 5).toString());
	}
	public void setEmpolyeeData(){
		employee.setFirstName(firstNameTextField.getText());
		employee.setLastName(lastNameTextField.getText());
		employee.setPhoneNumber(phoneNumberTextField.getText());
		employee.setSpecialization(specializationTextField.getText());
		employee.setSalary(Double.parseDouble(salaryTextField.getText()));
	}
}
