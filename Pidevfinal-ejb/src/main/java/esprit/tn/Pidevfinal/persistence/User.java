package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String login;
	
	@Column
	private String password;
	
	@Column
	private String firstName;
	
	@Column
	private String phone;
	
	public Integer getOnline() {
		return Online;
	}
	public void setOnline(Integer online) {
		Online = online;
	}
	@Column
	private String lastName;
	
	@Column
	private String Email;
      
	@Column
	  private Boolean isActif;
	  
	  @Column
	  private Integer Online;
	 
	  @Column
	  @Enumerated(EnumType.STRING)
	  private Role role;

	
	
	@OneToMany(mappedBy="user")
	private List<SousCategory> SousCategories;
	@OneToMany(mappedBy="idCreateur",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Topic> topics;
	@OneToMany(mappedBy="idPosteur")
	private List<Messages> messages;
	@OneToMany(mappedBy="idUser")
	private List<Reponse> reponses;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getMail() {
		return Email;
	}
	public void setMail(String mail) {
		this.Email = mail;
	}
	
	public List<SousCategory> getSousCategories() {
		return SousCategories;
	}
	public void setSousCategories(List<SousCategory> sousCategories) {
		SousCategories = sousCategories;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public List<Messages> getMessages() {
		return messages;
	}
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	public List<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User(Integer id, String login, String password, String firstName, String lastName, String email,
			Boolean isActif, Role role, List<SousCategory> sousCategories, List<Topic> topics, List<Messages> messages,
			List<Reponse> reponses) {
		super();
		this.id = id;
		login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.isActif = isActif;
		this.role = role;
		SousCategories = sousCategories;
		this.topics = topics;
		this.messages = messages;
		this.reponses = reponses;
	}
	public User(String login, String password, String firstName, String lastName, String email, Boolean isActif,
			Role role) {
		super();
		login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.isActif = isActif;
		this.role = role;
	}
	public User(Integer id, String login, String password, String firstName, String lastName, String email,
			Boolean isActif, Integer online, Role role) {
		super();
		this.id = id;
		login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.isActif = isActif;
		Online = online;
		this.role = role;
	}

	
	
	
}
