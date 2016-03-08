package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Car {
	
	@Id
	@GeneratedValue
	private long id;
	private String brand;
	private String model;
	private String vinNumber;
	private Date dateOfProduction;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Repair> repairs;
	
	public List<Repair> getRepairs() {
		return repairs;
	}

	public void setRepairs(List<Repair> repairs) {
		this.repairs = repairs;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public Date getDateOfProduction() {
		return dateOfProduction;
	}

	public void setDateOfProduction(Date dateOfProduction) {
		this.dateOfProduction = dateOfProduction;
	}
}
