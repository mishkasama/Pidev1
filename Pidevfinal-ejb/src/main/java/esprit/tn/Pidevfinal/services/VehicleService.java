package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.tn.Pidevfinal.persistence.Users;
import esprit.tn.Pidevfinal.persistence.Vehicle;
import esprit.tn.Pidevfinal.persistence.VehicleATTT;



@Stateless
@LocalBean
public class VehicleService implements VehicleServiceRemote{


	@PersistenceContext
	private EntityManager em;
	
	
	public String addVehicle(Vehicle vehicle){
		em.merge(vehicle);
		return vehicle.getMatriculation();
		
	}
	
	
	//Police police = em.find(Police.class, policeId);
	
	public void updateVehicleByMatriculation(String matriculation){
		
		Vehicle vehicle = em.find(Vehicle.class, matriculation);
	}
	
	@Override
	public List<Vehicle> findAll()
	{	
		  List<Vehicle> query = em.createQuery("Select v from Vehicle v ", Vehicle.class).getResultList();
		  return query;
	}
	
	@Override
	public List<Vehicle> getVehicleJPQL() {
		TypedQuery<Vehicle>query=em.createQuery("select v from Vehicle v",Vehicle.class);
		List<Vehicle>vehic=query.getResultList();
		Vehicle v=null;
		return vehic;
	}
//Matriculation
	
	@Override
	public void deleteVehicleById(String matriculation) {
		Query query= em.createQuery("Delete from Vehicle v where v.Matriculation=:matriculation");
		query.setParameter("MatriculationVehicule ", matriculation);
		query.executeUpdate();
		System.out.println("vehicle deleted succesfully !!!");
		
	}
	
//	@Override
//	public void deleteVehicleById(Integer vehicleID) {
//		Query query= em.createQuery("Delete from Vehicle v where v.id=:vehicleID");
//		query.setParameter("vehicleID", vehicleID);
//		query.executeUpdate();
//		System.out.println("vehicle deleted succesfully !!!");
//		
//	}

	@Override
	public void updateVehicle(Vehicle v) {
		em.merge(v);
		
	}

	@Override
	public List<Vehicle> getVehicleByIdInsured(int insured_id) {
		Users i =em.find(Users.class, insured_id);
			TypedQuery<Vehicle> query = em.createQuery("Select v from Vehicle v where v.idInsured=:i", Vehicle.class);
			List<Vehicle> vehic=query.setParameter("insured", i).getResultList();
			return vehic;
		}
	
	
	@Override
	public Users getInsuredByEMailMpd(String email, String password) {
		TypedQuery<Users> query = em.createQuery(
				"Select a from Insured a where a.email=:email and a.password=:password", Users.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		Users insured = null;
		
		try {
			insured = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Aucun insured trouve avec email : " + email);
		}
		return insured;
		
		
	}

	@Override
	public List<VehicleATTT> getAllVehicles(String i) {
		TypedQuery<VehicleATTT> query = em.createQuery
				("SELECT a FROM VehicleATTT a where a.Matriculation=:i",VehicleATTT.class);
					query.setParameter("i", i);
					List<VehicleATTT> vehicules=query.getResultList();
					return vehicules;
	}
	
	
	@Override
	public List<Vehicle> matriculation(String oldMatriculation) {
	
		TypedQuery<Vehicle> query = em.createQuery(
				"Select d from Vehicle v where v.Matriculation=oldMatriculation", Vehicle.class);
		query.setParameter("oldMatriculation", oldMatriculation);
		List<Vehicle> matriculation=query.getResultList();
		return  matriculation;
	}
	
}
