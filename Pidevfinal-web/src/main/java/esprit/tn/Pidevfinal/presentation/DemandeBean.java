package tn.esprit.JEEPI.presentation.mbeans;


import java.util.Date;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tn.esprit.JEEPI.services.DemandeService;
import tn.esprit.entity.ATTT;
import tn.esprit.entity.Demande;

@ManagedBean
@SessionScoped
public class DemandeBean {
	
	private int id;
	private Date date;
	private String  etat;
	private String type;
	private String oldMatriculation;
	private String newMatriculation;
	private String newVehicle;
	private String oldVehicle;
	private String name;
	
	
	private String newMark;
	private String oldMark;
	private String color;
	private String horsePower;
	private String Model;
	private String numChassis;
	
	
	
	private String matriculeTEST;
	private int test;
	private List<Demande>watingDemandes;
	
	private List<Demande>UneDemande;
	
	private List<Demande>valide;
	private List<Demande>invalide;
	private List<Demande>insDemande;
	
	
	private List<Demande> listTest;
	
	private List<ATTT> aTTTVehicle;
	
	private List<Demande>demandeVehicule;
	
	@EJB
	DemandeService demandeService;
	
	public List<Demande> getWatingDemandes()
	{
		watingDemandes= demandeService.getWatingDemande();
		return watingDemandes;
	}
	
	public List<Demande> valideDemande()
	{
		valide=demandeService.getValideDemandes();
		return valide;
	}
	
	public List<Demande> invalideDemande()
	{
		invalide=demandeService.getInvalideDemandes();
		return invalide;
	}
	
	
	
	/*public List<Demande> afficherdemande(int i)
	{
			
		insDemande=demandeService.getWatingDemandeById(i);
		return insDemande;
	}*/
	
	public String Details(int id,String type)
	{
		
		
	
		if(type.equals("update matriculation")==true)
		{
		insDemande=demandeService.getWatingDemandeById(id);
		return "/pages/Demande/insDemande?faces-redirect=true";
		}
		else
		{
			insDemande=demandeService.getWatingDemandeById(id);
			return "/pages/Demande/insDEmandeVehicle?faces-redirect=true";
		}
		 
	}
		
	
	
	Date datesys = new Date();
	
	
	
	public void TreatMatricleDemande(String oldmatriculation,int demandeId,String matriculeID,String newMatriculation)
	{
		//matriculeTEST=matricule;
		//System.out.println("***************" + getMatriculeTEST());
		listTest= demandeService.matriculation(oldmatriculation);
		
		if (listTest.size()!= 0)
		{	
		demandeService.UpdateDemande(demandeId,"valide");
		demandeService.updateMatriculeVehicle(newMatriculation,matriculeID);
		
		}
		else
		{
			demandeService.UpdateDemande(demandeId,"invalide");
			
		}
	}
	
	public String TreatVehicleDemande(String newmatriculation,String oldmatriculation,int demandeId,String vImmatriculation,
			String color,String horsPower, String model,int numChassis,String mark )
	{
		
		aTTTVehicle=demandeService.getAllVehicles(newmatriculation);
		demandeVehicule= demandeService.matriculation(oldmatriculation);
		
		if (demandeVehicule.size() != 0 && aTTTVehicle.size() != 0)
		{	
		demandeService.UpdateDemande(demandeId,"valide");
		demandeService.updateVehiculeVehicle(newmatriculation, color, horsPower, mark, model, numChassis, vImmatriculation);
		return "/pages/Demande/valideList?faces-redirect=true";
		}
		else
		{
			demandeService.UpdateDemande(demandeId,"invalide");
			
			return "/pages/Demande/invalideList?faces-redirect=true";
		}
	}
	
	
	
	
	
	
	
	
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

	public String getNewVehicle() {
		return newVehicle;
	}

	public void setNewVehicle(String newVehicle) {
		this.newVehicle = newVehicle;
	}

	public String getOldVehicle() {
		return oldVehicle;
	}

	public void setOldVehicle(String oldVehicle) {
		this.oldVehicle = oldVehicle;
	}

	public DemandeService getDemandeService() {
		return demandeService;
	}

	public void setDemandeService(DemandeService demandeService) {
		this.demandeService = demandeService;
	}

	public void setWatingDemandes(List<Demande> watingDemandes) {
		this.watingDemandes = watingDemandes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<Demande> getUneDemande() {
		return UneDemande;
	}
	public void setUneDemande(List<Demande> uneDemande) {
		UneDemande = uneDemande;
	}
	
	public List<Demande> getInvalideDemandes() {
		return invalide;
	}
	public void setInvalideDemandes(List<Demande> invalideDemandes) {
		this.invalide = invalideDemandes;
	}

	public List<Demande> getValide() {
		return valide;
	}

	public void setValide(List<Demande> valide) {
		this.valide = valide;
	}

	public List<Demande> getInvalide() {
		return invalide;
	}

	public void setInvalide(List<Demande> invalide) {
		this.invalide = invalide;
	}

	public List<Demande> getInsDemande() {
		return insDemande;
	}

	public void setInsDemande(List<Demande> insDemande) {
		this.insDemande = insDemande;
	}

	public String getMatriculeTEST() {
		return matriculeTEST;
	}

	public void setMatriculeTEST(String matriculeTEST) {
		this.matriculeTEST = matriculeTEST;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public List<Demande> getListTest() {
		return listTest;
	}

	public void setListTest(List<Demande> listTest) {
		this.listTest = listTest;
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

	public String getNumChassis() {
		return numChassis;
	}

	public void setNumChassis(String numChassis) {
		this.numChassis = numChassis;
	}

	public List<ATTT> getaTTTVehicle() {
		return aTTTVehicle;
	}

	public void setaTTTVehicle(List<ATTT> aTTTVehicle) {
		this.aTTTVehicle = aTTTVehicle;
	}

	public List<Demande> getDemandeVehicule() {
		return demandeVehicule;
	}

	public void setDemandeVehicule(List<Demande> demandeVehicule) {
		this.demandeVehicule = demandeVehicule;
	}

	public Date getDatesys() {
		return datesys;
	}

	public void setDatesys(Date datesys) {
		this.datesys = datesys;
	}
	
	

}
