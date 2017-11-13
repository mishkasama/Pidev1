package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class InsuranceProduct implements Serializable {

	private int id ; 
	private String title ; 
	private String text ;
	private int note ; 
	private int nb_rate;
	private int rate;
	private int moyRate;
	private String Deal;
	private byte[] img;
	private Insurance insurance;

	@Id
	@Column(name="id_Pro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public InsuranceProduct() {
		super();
	}
	public InsuranceProduct(String title, String text, String image) {
		super();
		this.title = title;
		this.text = text;
	
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public InsuranceProduct(String title, String text, String image, int note) {
		super();
		this.title = title;
		this.text = text;
		this.note = note;
	}
	public int getMoyRate() {
		return moyRate;
	}
	public void setMoyRate(int moyRate) {
		this.moyRate = moyRate;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getNb_rate() {
		return nb_rate;
	}
	public void setNb_rate(int nb_rate) {
		this.nb_rate = nb_rate;
	}
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(length=16777215)
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	@ManyToOne
	@JoinColumn(name = "id_In")
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public String getDeal() {
		return Deal;
	}

	public void setDeal(String deal) {
		Deal = deal;
	} 
	
	
	

}
