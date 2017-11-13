package tn.esprit.insurance.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Contract;
import tn.esprit.insurance.persistence.TypeContract;
import tn.esprit.insurance.persistence.Users;
import tn.esprit.insurance.persistence.Vehicle;

@Remote
public interface PoliceServiceRemote {
	public int addPolice(Contract police);
	public int addTypeContract(TypeContract typeContract);
	public int addInsured(Users insured);
	public int addVehicle(Vehicle vehicle);
	public void updatePoliceById(int policeId);
	public void updateTypeContractById(int typeContractId);
	public void updateTypeContract(TypeContract typeContractId);
	public void updateContract(Contract ContracId);
	public void cancelContract(int contractId);
	public Boolean deleteTypeContract(TypeContract typeContractId);
	public void affectContractToInsured(int contractId,int insureId);
	public void affectTypeContractToContract(int typeContractId,int contractId);
	public Contract getContractById(int contractId);
	public List<Contract> getContractByDate(Date date);
	public Users getInsuredById(int insuredId);
	public Vehicle getVehicleById(int vehicleId);
	public TypeContract getTypeContractById(int typeContractId);
	public List<Contract> getAllContract();
	public List<TypeContract> getAllTypeContract();
	public List<Users> getAllInsured();
	public List<Vehicle> getAllVehicle();  
	public void sendMail(String email,String name, String date);
	public void updateContractState(Contract Contrac);
	

}
