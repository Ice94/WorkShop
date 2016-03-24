package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CustomerPanel extends JPanel {
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JTable customersTable;

	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		setBounds(100, 100, 800, 600);
		setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(12, 55, 100, 15);
		add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(12, 86, 85, 15);
		add(lastNameLabel);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(12, 113, 70, 15);
		add(emailLabel);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number ");
		lblPhoneNumber.setBounds(12, 149, 115, 15);
		add(lblPhoneNumber);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(157, 53, 114, 19);
		add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(157, 84, 114, 19);
		add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(157, 111, 114, 19);
		add(emailTextField);
		emailTextField.setColumns(10);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setBounds(157, 147, 114, 19);
		add(phoneNumberTextField);
		phoneNumberTextField.setColumns(10);
		
		JButton addCustomerButton = new JButton("Add Customer");
		addCustomerButton.setBounds(76, 218, 160, 25);
		add(addCustomerButton);
		
		JButton deleteCustomerButton = new JButton("Delete Customer");
		deleteCustomerButton.setBounds(312, 218, 167, 25);
		add(deleteCustomerButton);
		
		JButton updateCustomerButton = new JButton("Update Customer");
		updateCustomerButton.setBounds(555, 218, 167, 25);
		add(updateCustomerButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 299, 722, 274);
		add(scrollPane);
		
		customersTable = new JTable();
		scrollPane.setViewportView(customersTable);
	}
}
