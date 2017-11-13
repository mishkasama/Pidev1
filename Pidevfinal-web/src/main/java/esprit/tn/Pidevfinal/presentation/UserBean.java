package tn.esprit.JEEPI.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.primefaces.context.RequestContext;

import tn.esprit.JEEPI.services.UserRemote;
import tn.esprit.entity.Role;
import tn.esprit.entity.Users;

@ManagedBean
@ViewScoped
public class UserBean {

	
	
	@EJB
	private UserRemote userlocal;
	private Users pers = new Users();
	private List<Users> personnes;
	private List<Users> fileteredUsers;
	private boolean formDisplayed = false;
	private Mail mail = new Mail();


	private int idUser;
	private String name;
	private Date BirthdayDate;
	private String adress;
	private String email;
	private String phone;
	@Column(unique=true)
	private String login;
	private	String password;
	private String searchRole;
	private List<Users> ls;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public UserBean() {

	}

	@PostConstruct
	public void init() {

		personnes = userlocal.findAllUsers();

	}



	
	//Ajout d'un user
	public void addUser (){
		userlocal.createUser(new Users( name,BirthdayDate,adress,email,phone,login,password,role));
		System.out.println("User added");		
		
	}
	
	
	public void envoiMail() {

		mail.setCorp("hi , " + pers.getName() + " "
					+ " Welcome to our Web Site ");
		mail.setTo(pers.getEmail());
		mail.send();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Confirmation Msg", "Invitation sent.");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	



	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Users getPers() {
		return pers;
	}

	public void setPers(Users pers) {
		this.pers = pers;
	}

	public List<Users> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Users> personnes) {
		this.personnes = personnes;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public List<Users> getFileteredUsers() {
		return fileteredUsers;
	}

	public void setFileteredUsers(List<Users> fileteredUsers) {
		this.fileteredUsers = fileteredUsers;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
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
	

public String getSearchRole() {
		return searchRole;
	}

	public void setSearchRole(String searchRole) {
		this.searchRole = searchRole;
	}

public void doSaveOrUpdate(){
		
		AuthentificationBean me = (AuthentificationBean)
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("authBean");
		
		userlocal.updateuser(me.getUser());
		
		formDisplayed =false;
		
	}

public String userByRole() {
	
	ls =userlocal.getUserByRole(searchRole);
	System.out.println("searchRole"+searchRole);
	System.out.println(ls);
	return "rechercheParRole";

	
}


//public void handleFileUpload(FileUploadEvent event) {
//	AuthenticationBean me = (AuthenticationBean)
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("authBean");
//	me.getUser().setImg(event.getFile().getContents());
//
//}
	
}
