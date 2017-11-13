package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * Entity implementation class for Entity: Insurance
 *
 */
@Entity

public class Insurance implements Serializable {

	
	private int Id;
	private String nameInsurance;
	private String phone;
	private String mail;
	private String description;
	private Date dateCreation;
	private int rate;
	private InsuranceProduct product;
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	



	public Insurance() {
		super();
	}   
	
	   
	@Id
	@Column(name="id_Ins")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getNameInsurance() {
		return this.nameInsurance;
	}

	public void setNameInsurance(String nameInsurance) {
		this.nameInsurance = nameInsurance;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}   
	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}


	@ManyToOne
	@JoinColumn(name = "id_Pro")
	public InsuranceProduct getProduct() {
		return product;
	}
	public void setProduct(InsuranceProduct product) {
		this.product = product;
	}
   
	
	
	
}
