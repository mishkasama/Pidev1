package tn.esprit.JEEPI.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.JEEPI.services.VehicleService;
import tn.esprit.entity.Users;
import tn.esprit.entity.Vehicle;
import tn.esprit.entity.VehicleATTT;

@ManagedBean
@SessionScoped
public class VehicleBean {


	//by YOSR
	
		private String Matriculation;
		
		private int NumChassis;
		private String Mark;
		private String Model;
		private String Color;
		private String HorsePower;
		
        private Vehicle vehicle;
		private List<Vehicle> vehicles;
		private VehicleATTT vattt;
		private List<VehicleATTT> aTTTVehicle;
		private String numchassisATTT;
		
		
		public String getMatriculation() {
			return Matriculation;
		}
		public void setMatriculation(String matriculation) {
			Matriculation = matriculation;
		}
		public int getNumChassis() {
			return NumChassis;
		}
		public void setNumChassis(int numChassis) {
			NumChassis = numChassis;
		}
		public String getMark() {
			return Mark;
		}
		public void setMark(String mark) {
			Mark = mark;
		}
		public String getModel() {
			return Model;
		}
		public void setModel(String model) {
			Model = model;
		}
		public String getColor() {
			return Color;
		}
		public void setColor(String color) {
			Color = color;
		}
		public String getHorsePower() {
			return HorsePower;
		}
		public void setHorsePower(String horsePower) {
			HorsePower = horsePower;
		}
		public List<Vehicle> getVehicle(){
			vehicles=vehicleservice.getVehicleJPQL();
			return vehicles;
		}
		public void setVehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
		}
		public List<Vehicle> getVehicles() {
			return vehicles;
		}
		public void setVehicles(List<Vehicle> vehicles) {
			this.vehicles = vehicles;
		}
		public VehicleATTT getVattt() {
			return vattt;
		}
		public void setVattt(VehicleATTT vattt) {
			this.vattt = vattt;
		}
		public String getNumchassisATTT() {
			return numchassisATTT;
		}
		public void setNumchassisATTT(String numchassisATTT) {
			this.numchassisATTT = numchassisATTT;
		}
		
		
		@EJB
		VehicleService vehicleservice;
		
		private AuthentificationBean aut;
		
		
		
		public void addVehicle(Users user){
			System.out.println("---------------"+user.getEmail());
			vehicleservice.addVehicle(new Vehicle( Matriculation, NumChassis, Mark,  Model,  Color,  HorsePower,user));
			System.out.println("Vehicle added");
			}
		
	
		public List<Vehicle> getMyVehicleByInsuredId(int id){
			
		vehicles =	vehicleservice.getVehicleByIdInsured(id);
		return vehicles;
		
		}
		
		public void doSaveOrUpdate(){
			
//			AuthentificationBean me = (AuthentificationBean)
//					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("authBean");

			
			//vehicleservice.updateVehicle(v);
			
			//formDisplayed =false;
			
		}
		
		public void SupprimerVehicle(String matriculation){
			vehicleservice.deleteVehicleById(matriculation);
			
		}
		public VehicleService getVehicleservice() {
			return vehicleservice;
		}
		public void setVehicleservice(VehicleService vehicleservice) {
			this.vehicleservice = vehicleservice;
		}
	
		public String TreatVehicleDemande(String Newmatriculation, String oldmatriculation)
		{
			
			aTTTVehicle=vehicleservice.getAllVehicles(Newmatriculation);
			vehicles= vehicleservice.matriculation(oldmatriculation);
			
			if (aTTTVehicle.size() != 0 && vehicles.size() != 0)
			{	
				vehicleservice.addVehicle(vehicle);
				//UpdateDemande(demandeId,"valide");
				//vehicleservice.updateVehiculeVehicle(newmatriculation, color, horsPower, mark, model, numChassis, vImmatriculation);
			return "/pages/VehicleManagement/vehicle?faces-redirect=true";
			}
			else
			{
				//vehicleservice.UpdateDemande(demandeId,"invalide");
				FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage(" Invalide Demande"));
				return "/pages/VehicleManagement/vehicle?faces-redirect=true";
			}
		}
}
