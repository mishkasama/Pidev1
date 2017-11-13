package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.tn.Pidevfinal.persistence.Address;
import esprit.tn.Pidevfinal.persistence.Insurance;


@Remote
public interface AddresServiceRemote {
public List<String>  getAllTown();
public List<Address>  getAllListTown();
public List<Insurance> getLocalisation();

}
