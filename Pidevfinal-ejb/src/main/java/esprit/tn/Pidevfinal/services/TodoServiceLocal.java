package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.Pidevfinal.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
