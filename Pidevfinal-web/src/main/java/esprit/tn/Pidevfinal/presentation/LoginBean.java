package tn.esprit.JEEPI.presentation.mbeans;



import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tn.esprit.JEEPI.services.DemandeService;
import tn.esprit.entity.Agent;



@ManagedBean
@SessionScoped
public class LoginBean {
	private String mdp;
	private String email;
	private Agent agent;

	private boolean loggedIn;

	@EJB
	DemandeService demandeService;
	
	public String doLogin()
	{
		String navigateTo="null";
		agent = demandeService.getAgentByEMailMpd(email, mdp);
		if(agent != null)
		{
			navigateTo = "/pages/Demande/welcome?faces-redirect=true";
			loggedIn =true;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage(" bad credentials"));
		}
		return navigateTo;
	}
	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/Demande/login?faces-redirect=true";
	}
	
	
	
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public DemandeService getEmpoyeService() {
		return demandeService;
	}
	public void setEmpoyeService(DemandeService empoyeService) {
		this.demandeService = empoyeService;
	}
	
	
	
}
