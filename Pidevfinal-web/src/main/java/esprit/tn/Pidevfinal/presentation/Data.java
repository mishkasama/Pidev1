package tn.esprit.JEEPI.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.entity.Role;

@ManagedBean
@ApplicationScoped
public class Data {
	   public Role[] getStatuses() {
	        return Role.values();
	    }

}
