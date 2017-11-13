package tn.esprit.insurance.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Insured implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdInsured;
	
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="insured")
	private List<Contract> polices;

	public Insured() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insured(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getIdInsured() {
		return IdInsured;
	}

	public void setIdInsured(int idInsured) {
		IdInsured = idInsured;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Contract> getPolices() {
		return polices;
	}

	public void setPolices(List<Contract> polices) {
		this.polices = polices;
	}
	
	

}
