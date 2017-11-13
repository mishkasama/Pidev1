package tn.esprit.insurance.services;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.insurance.persistence.Insured;
import tn.esprit.insurance.persistence.Contract;
import tn.esprit.insurance.persistence.TypeContract;
import tn.esprit.insurance.persistence.Users;
import tn.esprit.insurance.persistence.Vehicle;

@Stateless
public class PoliceService implements PoliceServiceRemote{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int addPolice(Contract police) {
		// TODO Auto-generated method stub
		em.persist(police);
		return police.getNumPolice();
	}

	@Override
	public int addInsured(Users insured) {
		// TODO Auto-generated method stub
		em.persist(insured);
		return insured.getId();
	}
	
	@Override
	public int addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		em.persist(vehicle);
		return vehicle.getNumChassis();
	}
	
	@Override
	public int addTypeContract(TypeContract typeContract) {
		// TODO Auto-generated method stub
		em.persist(typeContract);
		return typeContract.getIdTypeContrat();
	}

	@Override
	public void updateContract(Contract Contrac){
		em.merge(Contrac);
	}
	
	@Override
	public void updatePoliceById(int policeId) {
		// TODO Auto-generated method stub
		Contract police = em.find(Contract.class, policeId);
		
		
	}

	@Override
	public void updateTypeContractById(int typeContractId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelContract(int contractId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean deleteTypeContract(TypeContract typeContractId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void affectContractToInsured(int contractId, int insureId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affectTypeContractToContract(int typeContractId, int contractId) {
		// TODO Auto-generated method stub
		
	}

	public Contract getContractById(int contractId) {
		// TODO Auto-generated method stub
		Contract e = em.find(Contract.class, contractId);
		
		return e;
	
	}
	
	@Override
	public Vehicle getVehicleById(int vehicleId) {
		// TODO Auto-generated method stub
		Vehicle e = em.find(Vehicle.class, vehicleId);
		
		return e;
	
	}
	
	@Override
	public Users getInsuredById(int insuredId) {
		// TODO Auto-generated method stub
		Users e = em.find(Users.class, insuredId);
		
		return e;
	}

	@Override
	public TypeContract getTypeContractById(int typeContractId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> getAllContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeContract> getAllTypeContract() {
		// TODO Auto-generated method stub
		TypedQuery<TypeContract> query = em.createQuery("Select e from TypeContract e", TypeContract.class);
		List<TypeContract> listTypeContract = null;
		try{
			listTypeContract = query.getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listTypeContract;
		
	}

	@Override
	public List<Users> getAllInsured() {
		// TODO Auto-generated method stub
		TypedQuery<Users> query = em.createQuery("Select e from Users e", Users.class);
		List<Users> listInsured = null;
		try{
			listInsured = query.getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listInsured;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		TypedQuery<Vehicle> query = em.createQuery("Select e from Vehicle e", Vehicle.class);
		List<Vehicle> listVehicle = null;
		try{
			listVehicle = query.getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listVehicle;
	}
	
	public List<Contract> getContractByDate(Date date){
		TypedQuery<Contract> query = em.createQuery("Select e from Contract e where e.endDate = :date", Contract.class);
		List<Contract> listContract = null;
		try{
			listContract = query.setParameter("date", date).getResultList();
		}catch(NoResultException e){
			//Logger.info("Aucun employe trouvé pour cet email: "+email);
		}
		return listContract;
		
	}
	
	public void sendMail(String email,String name, String date) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("aboudimariem93@gmail.com","58323183A");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("meriem.aboudi@esprit.tn"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("meriem.aboudi@esprit.tn"));
			message.setSubject("Expiration contract");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void updateContractState(Contract Contrac){
		System.out.println("--------------------- Contrac.getNumPolice() :: "+Contrac.getNumPolice());
		Query query = em.createQuery("UPDATE Police p SET state = false where p.numPolice = :pid");
		int updateCount = query.setParameter("pid", Contrac.getNumPolice()).executeUpdate();
	}
	public void updateTypeContract(TypeContract typeContractId){
		em.merge(typeContractId);
	}
}
