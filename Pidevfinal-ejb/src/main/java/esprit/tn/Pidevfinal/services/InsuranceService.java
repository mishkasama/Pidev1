package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import esprit.tn.Pidevfinal.persistence.Insurance;


@Stateless
@LocalBean
public class InsuranceService implements InsuranceServiceRemote {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addInsurance(Insurance insurance) {
		em.persist(insurance);
	}

	@Override
	public void updateInsurance(Insurance assurancee) {
em.merge(assurancee);	
	}

	@Override
	public void deleteInsurance(int insuranceId) {
		em.remove(em.find(Insurance.class, insuranceId));
		
	}

	@Override
	public Insurance getInsuranceById(int insuranceId) {
		Insurance i = em.find(Insurance.class,insuranceId);
		return i;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		TypedQuery<Insurance> query = em.createQuery(
			      "SELECT c FROM Insurance c ", Insurance.class);
		return query.getResultList();
	}

	

}