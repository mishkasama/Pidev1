package esprit.tn.Pidevfinal.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.tn.Pidevfinal.persistence.Users;




@Stateless
@LocalBean
public class UserServices implements UserRemote{

	@PersistenceContext(unitName = "")
	private EntityManager em;
	
	
	
	public UserServices() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int createUser(Users user) {
		em.merge(user);
		return user.getId();
	}

	public List<Users> findAllUsers() {
		return em.createQuery("select u from Users u").getResultList();
	}
	
	
	public Users findUserByLogin(String login) {
		Users found = null;
		String jpql = "select u from Users u where u.login=:login";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		try{
			found = (Users) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
		
	}
	
	
	public List<Users> findUsersNotMe(int iduser) {
		Query q = em.createQuery("select a from Personne a");	
		List<Users> mAll = new ArrayList<Users>();
		List<Users> mByid = new ArrayList<Users>();
		mAll=q.getResultList();
		Iterator<Users> it = mAll.iterator();

		while (it.hasNext()) {
			Users m= new Users();
			m=it.next();
			if(m.getId()!=iduser){
				mByid.add(m);
						
			}
	 
		}
		 return mByid;
	}
	
	public Users findUserById(int id) {
		Users found = null;
		String jpql = "select u from Users u where u.id=:x";
		Query query = em.createQuery(jpql);
		query.setParameter("x",id);
		try{
			found = (Users) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
		
	}

	public Users authenticate(String login, String password) {

		Users found = null;
		String jpql = "select u from Users u where u.login=:login and u.password=:password ";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try{
			found = (Users) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
		
	}

	public boolean loginExists(String login) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from Users u where u.login=:login";
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		exists = (Boolean)query.getSingleResult();
		return exists;	}

	@Override
	public List<Users> getUserByRole(String role) {
		
		
		System.out.println("Role ser"+role);
		TypedQuery<Users> query = em.createQuery("Select u from Users u "   + "where u.role=:role",Users.class);
				query.setParameter("role",role);
				
				List <Users> users = null;
				try 
				{users = query.getResultList();
				}catch(NoResultException e)
				{
					//Logger.info("aucun utilisateur trouve avec role : " + role);
					System.out.println("acces refus");
					}
				System.out.println(users);
				
				return users;
		
	}


	
	@Override
	public void updateuser(Users user) {
		em.merge(user);
		
	}
	
	public int createUser1(Users user) {
		em.persist(user);
		em.flush();
		return user.getId();
	}
	
	public void updateUser(Users user)
	{
		em.merge(user);
	}

	public Users getUserById(int id) {
		return em.find(Users.class, id);
	}

}
