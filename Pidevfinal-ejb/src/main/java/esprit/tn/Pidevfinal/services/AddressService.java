package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import esprit.tn.Pidevfinal.persistence.Address;
import esprit.tn.Pidevfinal.persistence.Insurance;



@Stateless
@LocalBean
public class AddressService implements AddresServiceRemote {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<String> getAllTown() {
		TypedQuery<String> query = em.createQuery(
			      "SELECT c.name FROM Address c ", String.class);
		List<String> a= query.getResultList();
		return a;
	}
	@Override
	public List<Address> getAllListTown() {
		TypedQuery<Address> query = em.createQuery(
			      "SELECT  c FROM Address c ", Address.class);
		List<Address> a= query.getResultList();
		return a;
	}

	public List<Insurance> getLocalisation() {
		TypedQuery<Insurance> query = em.createQuery("SELECT i FROM Insurance i , Address d where d.id=i.addresse  ",Insurance.class);
		List<Insurance> demandes=query.getResultList();
		return demandes;

	}
	

}
