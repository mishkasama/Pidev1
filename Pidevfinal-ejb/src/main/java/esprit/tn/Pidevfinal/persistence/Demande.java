package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.ApplicationException;
import javax.persistence.*;


@Entity
public class Demande implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date date;
	private String  etat;
	private String type;
	private String oldMatriculation;
	private String newMatriculation;
	private String newMark;
	private String oldMark;
	private String color;
	private String horsePower;
	private String Model;
	@Column(nullable = true)
	private int numChassis;
	
	
	@ManyToOne
	private Users users;

	@ManyToOne
	private Vehicle vehicle;

	public Demande(){};
	
	
	
	
	
	
	//************ demande vehicule
	
	
	
	//********* demande matricule

	
		



	//datesys, "wating", "update matriculation", oldMatriculation, newMatriculation
	






	public Demande(Date date, String state, String type, String oldMatriculation, String newMatriculation) {
		super();
		this.date = date;
		this.type = type;
		this.etat=state;
		this.oldMatriculation = oldMatriculation;
		this.newMatriculation = newMatriculation;
	}






	public Demande(Date date, String etat, String type, String oldMatriculation, String newMatriculation, Users users,
			Vehicle vehicle) {
		super();
		this.date = date;
		this.etat = etat;
		this.type = type;
		this.oldMatriculation = oldMatriculation;
		this.newMatriculation = newMatriculation;
		this.users = users;
		this.vehicle = vehicle;
	}






	public Demande(Date date, String etat, String type, String oldMatriculation, String newMatriculation,
			String oldMark, Users users, Vehicle vehicle) {
		super();
		this.date = date;
		this.etat = etat;
		this.type = type;
		this.oldMatriculation = oldMatriculation;
		this.newMatriculation = newMatriculation;
		this.oldMark = oldMark;
		this.users = users;
		this.vehicle=vehicle;
		
	}



	public Demande(Date date, String etat, String type, String oldMatriculation, String newMatriculation,
			String newMark, String color, String horsePower, String model, int numChassis, Users users,
			Vehicle vehicle) {
		super();
		
		this.date = date;
		this.etat = etat;
		this.type = type;
		this.oldMatriculation = oldMatriculation;
		this.newMatriculation = newMatriculation;
		this.newMark = newMark;
		this.color = color;
		this.horsePower = horsePower;
		this.Model = model;
		this.numChassis = numChassis;
		this.users = users;
		this.vehicle=vehicle;
		
	}


	






	/*public Demande(Date date, String etat, String type, String oldMatriculation, String newMatriculation, Insured insured) {
	
		this.date = date;
		this.etat = etat;
		this.type = type;
		this.oldMatriculation = oldMatriculation;
		this.newMatriculation = newMatriculation;
		//this.insured.getId()=in
		//insuredId=this.getInsured().getId();
		this.insured=insured;
		
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOldMatriculation() {
		return oldMatriculation;
	}
	public void setOldMatriculation(String oldMatriculation) {
		this.oldMatriculation = oldMatriculation;
	}
	public String getNewMatriculation() {
		return newMatriculation;
	}
	public void setNewMatriculation(String newMatriculation) {
		this.newMatriculation = newMatriculation;
	}
	public String getNewMark() {
		return newMark;
	}
	public void setNewMark(String newMark) {
		this.newMark = newMark;
	}
	public String getOldMark() {
		return oldMark;
	}
	public void setOldMark(String oldMark) {
		this.oldMark = oldMark;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(String horsePower) {
		this.horsePower = horsePower;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getNumChassis() {
		return numChassis;
	}
	public void setNumChassis(int numChassis) {
		this.numChassis = numChassis;
	}
	
	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	public Vehicle getVehicle() {
		return vehicle;
	}






	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	
	



	
	
}
