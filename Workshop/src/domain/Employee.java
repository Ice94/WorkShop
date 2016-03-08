package domain;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {
	private String specialization;
	private double salary;

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
