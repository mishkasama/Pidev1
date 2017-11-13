package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
public class Users implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Date BirthdayDate;
	private String adress;
	private String email;
	private String phone;
	@Column(unique=true)
	private String login;
	private	String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	@OneToMany(mappedBy="users")
	private List<Demande> demandes;

	public Users() {
		super();
	}
		
	
	
	public Users(int id) {
		super();
		this.id = id;
	}



	public List<Demande> getDemandes() {
		return demandes;
	}



	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdayDate() {
		return BirthdayDate;
	}
	public void setBirthdayDate(Date birthdayDate) {
		BirthdayDate = birthdayDate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	

	public Users(int id, String name, Date birthdayDate, String adress, String email, String phone, String login,
			String password, Role role) {
		super();
		this.id = id;
		this.name = name;
		BirthdayDate = birthdayDate;
		this.adress = adress;
		this.email = email;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.role = role;
	}



	public Users(String name, Date birthdayDate, String adress, String email, String phone, String login,
			String password, Role role) {
		super();
		this.name = name;
		BirthdayDate = birthdayDate;
		this.adress = adress;
		this.email = email;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	
	
   
}
