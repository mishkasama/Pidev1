package tn.esprit.JEEPI.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.JEEPI.services.DemandeService;
import tn.esprit.entity.Users;

@ManagedBean
@SessionScoped
public class LoginInsuredBean {
	
	private String mdp;
	private String email;
	private Users insured;
	private boolean loggedIn;
	
	@EJB
	DemandeService demandeService;
	
	public String doLogin()
	{
		String navigateTo="null";
		insured = demandeService.getInssuredByLoginMdp(email, mdp);
		if(insured != null)
		{
			navigateTo = "/pages/Demande/matricule?faces-redirect=true";
			loggedIn =true;
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage(" bad credentials"));
		}
		return navigateTo;
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

	public Users getInsured() {
		return insured;
	}

	public void setInsured(Users insured) {
		this.insured = insured;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public DemandeService getDemandeService() {
		return demandeService;
	}

	public void setDemandeService(DemandeService demandeService) {
		this.demandeService = demandeService;
	}

}
