package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.Pidevfinal.persistence.Users;
import esprit.tn.Pidevfinal.persistence.Vehicle;
import esprit.tn.Pidevfinal.persistence.VehicleATTT;




@Remote
public interface VehicleServiceRemote {

	
	public String addVehicle(Vehicle vehicle);
	public void updateVehicleByMatriculation(String matriculation);
	public List<Vehicle> findAll();
	public List<Vehicle> getVehicleJPQL();
	public void deleteVehicleById(String matriculation) ;
	public void updateVehicle(Vehicle v);
	public List<Vehicle> getVehicleByIdInsured(int insured_id) ;
	public Users getInsuredByEMailMpd(String email, String password);
	public List<VehicleATTT> getAllVehicles(String i);
	public List<Vehicle> matriculation(String oldMatriculation) ;
	
}
