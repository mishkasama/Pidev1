package esprit.tn.Pidevfinal.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.Pidevfinal.persistence.Users;






@Local
public interface UserRemote {
	
	public int createUser(Users user) ;
	public List<Users> findAllUsers() ;
	public Users findUserByLogin(String login) ;
	public Users findUserById(int id);
	public List<Users> findUsersNotMe(int iduser) ;
	public Users authenticate(String login, String password);
	public boolean loginExists(String login);
	//public byte[] findPictureByPersonneId(int idPersonne) ;
	public void updateuser(Users user);
	public int createUser1(Users user) ;
	public void updateUser(Users user);
	public Users getUserById(int id);
	public List<Users> getUserByRole(String role);
	
	
	//public Users findbylogin(String login);

//	public void update(Users user);
//
//	public List<Users> listUser();



	
	
	

}
