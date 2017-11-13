package esprit.tn.Pidevfinal.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class VehiclesWreck {

	
	@Id
	private String Matriculation;
	
	private String Mark;

	private int ChassisNumber;

	public int getChassisNumber() {
		return ChassisNumber;
	}

	public void setChassisNumber(int chassisNumber) {
		ChassisNumber = chassisNumber;
	}

	public String getMark() {
		return Mark;
	}
	public void setMark(String mark) {
		Mark = mark;
	}
	public String getMatriculation() {
		return Matriculation;
	}
	public void setMatriculation(String matriculation) {
		Matriculation = matriculation;
	}
	public VehiclesWreck() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VehiclesWreck(String mark, int chassisNumber) {
		super();
		Mark = mark;
		ChassisNumber = chassisNumber;
	}

	public VehiclesWreck(String matriculation, String mark, int chassisNumber) {
		super();
		Matriculation = matriculation;
		Mark = mark;
		ChassisNumber = chassisNumber;
	}

	
	
}
