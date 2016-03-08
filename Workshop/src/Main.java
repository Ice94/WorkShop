

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Car;
import domain.Customer;
import domain.Employee;
import domain.Repair;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//
		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Kant");
		employee.setPhoneNumber("123456789");
		employee.setSpecialization("Blacharz");
		employee.setSalary(2000.0);
		
		Customer customer = new Customer();
		customer.setFirstName("Mateusz");
		customer.setLastName("B");
		customer.setPhoneNumber("987654321");
		customer.setEmailAddress("mhratek@gmail.com");
		
		Car car1 = new Car();
		car1.setBrand("Ferrari");
		car1.setModel("458");
		car1.setVinNumber("QWERTY654321");
		
		Car car2 = new Car();
		car2.setBrand("Ford");
		car2.setModel("Focus");
		car2.setVinNumber("123456QWERTY");
		
		Repair repair = new Repair();
		repair.setDescription("Opis");
		repair.setCosts(1214.00);
	
		List<Repair> repairs = new ArrayList<>();
		repairs.add(repair);
		
		car1.setRepairs(repairs);
//		car2.setRepairs(repairs);
		
		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		
		
		
		customer.setCars(cars);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(customer);
		entityManager.persist(car1);
		entityManager.persist(car2);
		entityManager.persist(repair);
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
