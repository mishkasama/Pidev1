package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.Pidevfinal.persistence.Insurance;



@Remote
public interface InsuranceServiceRemote {
	public void addInsurance(Insurance insurance);
	public void updateInsurance(Insurance assurance);
	public void deleteInsurance(int insuranceId);
	public Insurance getInsuranceById(int insuranceId);
	public List<Insurance> getAllInsurance();

}
