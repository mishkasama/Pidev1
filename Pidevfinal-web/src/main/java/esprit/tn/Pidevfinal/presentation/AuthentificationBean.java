package tn.esprit.JEEPI.presentation.mbeans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


//import edu.com.managedBean.Email;
import tn.esprit.JEEPI.services.UserRemote;
import tn.esprit.JEEPI.services.UserServices;
import tn.esprit.entity.Role;
import tn.esprit.entity.Users;



@ManagedBean(name="authBean")
@SessionScoped
public class AuthentificationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserServices authenticationServiceLocal;
	//UserRemote authenticationServiceLocal;
	
	private int idUser;
	private Users user;
	public static Users currentuser;
	private boolean loggedIn;
	private List<Users> users;
	private String login;
	private String password;
	
	
	public static Users getCurrentuser() {
		return currentuser;
	}

	public static void setCurrentuser(Users currentuser) {
		AuthentificationBean.currentuser = currentuser;
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

	public AuthentificationBean() {
	}
	
	@PostConstruct
	public void init(){
		user = new Users();
		users=authenticationServiceLocal.findAllUsers();
		setLoggedIn(false);
	}
	
	public String doLogin(){
		String navigateTo = null;
		user=authenticationServiceLocal.authenticate(user.getLogin(), user.getPassword());
		if (user != null && user.getRole()==Role.Insured) {
			
			
			loggedIn = true;
			this.idUser = user.getId();
//			FacesContext.getCurrentInstance()
//			.addMessage("login_form:login_submit", new FacesMessage("okkkk!"));
			System.out.println(idUser);
			navigateTo = "/pages/VehicleManagement/vehicle?face-redirect=true";
	}
		
		
		else if (user != null && user.getRole()==Role.Administrator) {
			
			loggedIn = true;
			this.idUser =user.getId();
			navigateTo = "/pages/UserManagement/register?face-redirect=true";
	}
		
		else if (user != null && user.getRole()==Role.Agent) {
			
			loggedIn = true;
			this.idUser =user.getId();
			navigateTo = "/pages/UserManagement/Profile?face-redirect=true";
	}
		else if (user != null && user.getRole()==Role.Expert) {
			
			loggedIn = true;
			this.idUser =user.getId();
			navigateTo = "/pages/UserManagement/Profile?face-redirect=true";
	}
			else {
		FacesContext.getCurrentInstance()
			.addMessage("login_form:login_submit", new FacesMessage("Bad Credentials!"));
	}
		return navigateTo;
	}

	public String doLogout(){
		String navigateTo = null;
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		init();
		navigateTo = "/pages/UserManagement/login?faces-redirect=true";
		//currentuser=null;
		return navigateTo;
	}
	public Users getUser() {
		return user;
	}
	
	public String doRegister(){
		String navigateTo = null;

		if(authenticationServiceLocal.createUser1(user)!=0 )
		{
			
			Email email = new Email();
			email.sendConfirmationMail(user);
		}
		navigateTo = "/pages/UserManagement/login?faces-redirect=true";
		return navigateTo;

	}

	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	
	
	
	
}
