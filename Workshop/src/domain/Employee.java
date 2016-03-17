package domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

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

		entityManager.getTransaction().begin();
		entityManager.persist(this);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void deleteEmployee(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Employee> delete = criteriaBuilder.createCriteriaDelete(Employee.class);
		Root e = delete.from(Employee.class);
		
		delete.where(criteriaBuilder.equal(e.get("id"), id));
		
		entityManager.getTransaction().begin();
		entityManager.createQuery(delete).executeUpdate();
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

	public void updateData(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Employee> update = criteriaBuilder.createCriteriaUpdate(Employee.class);
		Root e = update.from(Employee.class);
		
		
		update.set("firstName", employee.getFirstName());
		update.set("lastName", employee.getLastName());
		update.set("phoneNumber", employee.getPhoneNumber());
		update.set("salary", employee.getSalary());
		update.set("specialization", employee.getSpecialization());
		
		update.where(criteriaBuilder.equal(e.get("id"), employee.getId()));
		
		entityManager.getTransaction().begin();
		entityManager.createQuery(update).executeUpdate();
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

	public List<Employee> getEmployees() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Employee> employees = new ArrayList<>();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Employee> from = criteriaQuery.from(Employee.class);

		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entityManager.createQuery(select);
		List<Object> resultList = typedQuery.getResultList();

		for (Object o : resultList) {
			employees.add((Employee) o);
		}
		entityManager.close();
		entityManagerFactory.close();
		return employees;
	}
}
