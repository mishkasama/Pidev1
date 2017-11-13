package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.ApplicationException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Vehicle implements Serializable{
	
	@Id
	private String Matriculation;
	private int NumChassis;
	private String Mark;
	private String Model;
	private String Color;
	private String HorsePower;
	
	

	@OneToMany(mappedBy="vehicle")
	private List<Demande> ds;

	

	public Vehicle(){}
	
	public Vehicle(String matriculation) {
		this.Matriculation = matriculation;
	}



	public String getMatriculation() {
		return Matriculation;
	}



	public void setMatriculation(String matriculation) {
		Matriculation = matriculation;
	}



	public int getNumChassis() {
		return NumChassis;
	}



	public void setNumChassis(int numChassis) {
		NumChassis = numChassis;
	}



	public String getMark() {
		return Mark;
	}



	public void setMark(String mark) {
		Mark = mark;
	}



	public String getModel() {
		return Model;
	}



	public void setModel(String model) {
		Model = model;
	}



	public String getColor() {
		return Color;
	}



	public void setColor(String color) {
		Color = color;
	}



	public String getHorsePower() {
		return HorsePower;
	}



	public void setHorsePower(String horsePower) {
		HorsePower = horsePower;
	}



	
	public List<Demande> getDs() {
		return ds;
	}

	public void setDs(List<Demande> ds) {
		this.ds = ds;
	}
	
	
	
	
	
	
	
	
	
	

}
