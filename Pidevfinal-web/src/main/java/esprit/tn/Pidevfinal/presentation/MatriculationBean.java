package tn.esprit.JEEPI.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.JEEPI.services.DemandeService;
import tn.esprit.entity.Demande;
import tn.esprit.entity.Users;
import tn.esprit.entity.Vehicle;


@ManagedBean
@SessionScoped
public class MatriculationBean {
	
	private int id;
	private Date date;
	private String  etat;
	private String type;
	private String oldMatriculation;
	private String newMatriculation;
	private String newVehicle;
	private String oldVehicle;
	
	private String newMark;
	private String oldMark;
	private String color;
	private String horsePower;
	private String Model;
	private int numChassis;
	
	@EJB
	DemandeService demandeService;
	
	Date datesys = new Date();
	
	private List<Demande>watingDemandes;
	private List<Demande>valideDemandes;
	
	public String updateMatriculation()
	{
		
		//Demande d = new Demande(datesys, "wating", "update matriculation", oldMatriculation, newMatriculation, oldMark,new Users(1),new Vehicle("aa"));
		//demandeService.AddDemande(d);
		Users u = new Users(2);
		Vehicle v = new Vehicle("120tunisie1478");
		Demande d= new  Demande(datesys, "wating", "update matriculation", oldMatriculation, newMatriculation,u,v);
		demandeService.AddDemande(d);
		return "/pages/Demande/watingDemandesUsers?faces-redirect=true";
		
	}
	
	
	public void updateVehicule()
	{
		Users u = new Users(2);
		Vehicle v = new Vehicle(oldMatriculation);
		  Demande d = new Demande( datesys, "wating", "update vehicle", oldMatriculation, newMatriculation, newMark, color, horsePower, newMark, numChassis,u,v);
		demandeService.AddDemande(d);
	}
	
	public List<Demande> getWatingDemandes()
	{
		watingDemandes= demandeService.getWatingDemandesUser(2);
		return watingDemandes;
	}
	
	public List<Demande> getValideDemandes()
	{
		valideDemandes= demandeService.getValideDemandeUser(2);
		return valideDemandes;
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

	

	public DemandeService getDemandeService() {
		return demandeService;
	}

	public void setDemandeService(DemandeService demandeService) {
		this.demandeService = demandeService;
	}

	public Date getDatesys() {
		return datesys;
	}

	public void setDatesys(Date datesys) {
		this.datesys = datesys;
	}

	public int getNumChassis() {
		return numChassis;
	}

	public void setNumChassis(int numChassis) {
		this.numChassis = numChassis;
	}


	public void setWatingDemandes(List<Demande> watingDemandes) {
		this.watingDemandes = watingDemandes;
	}
	
	
	/*public String addContract(){
		System.out.println("startDate: ++");
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("selectedInsureId: "+selectedInsureId);
		System.out.println("startDate: "+simpleFormat.format(startDate));
		System.out.println("endDate: "+simpleFormat.format(endDate));
		Police c = new Police((Date) startDate, (Date)  endDate, price, 8);

		Insured ins = new Insured();
		Vehicle vehicle = new Vehicle();
		TypeContract tpc = new TypeContract();
		
		vehicle = policeService.getVehicleById(selectedVehicleId);
		tpc = policeService.getTypeContractById(selectedTypeContactId);
		ins = policeService.getInsuredById(selectedInsureId);
		
		c.setInsured(ins);
		c.setVehicle(vehicle);
		c.setTypeContrat(tpc);
		System.out.println("contract.setInsured(ins);");
	
		int x =policeService.addPolice(c);
		System.out.println("fin");
		return "/pages/policeManagement/listContract.jsf?faces-redirect=true";
	}*/
	
}
