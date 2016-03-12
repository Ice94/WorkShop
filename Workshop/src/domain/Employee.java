package domain;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

	public void addEmployee() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println(this.getFirstName());
		entityManager.getTransaction().begin();
		entityManager.persist(this);
		entityManager.getTransaction().commit();
	}

	public void deleteEmployee() {

	}

}
