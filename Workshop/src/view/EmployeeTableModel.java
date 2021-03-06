package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Employee;

public class EmployeeTableModel extends AbstractTableModel {

	private List<Employee> employees;
	private String[] nameColums = {"Id","First Name", "Last Name", "Phone number", "Salary", "Specialization"};
	public EmployeeTableModel(List<Employee> employees) {
		this.employees = employees;

	}

	@Override
	public int getColumnCount() {

		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return employees.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Employee employee = employees.get(row);
		switch (col) {
		case 0:
			return employee.getId();

		case 1:
			return employee.getFirstName();

		case 2:
			return employee.getLastName();

		case 3:
			return employee.getPhoneNumber();

		case 4:
			return employee.getSalary();

		case 5:
			return employee.getSpecialization();

		default:
			return null;

		}
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return nameColums[column];
	}
}
