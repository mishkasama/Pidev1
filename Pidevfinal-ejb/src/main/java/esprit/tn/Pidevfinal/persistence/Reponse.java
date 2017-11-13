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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Reponse implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReponse;
	
	@Column
	private String contenu;
	
	@Temporal(TemporalType.DATE)
	private Date datePost;
	
	@Temporal(TemporalType.DATE)
	private Date dateEdit;
	
	@ManyToOne
	@JoinColumn(name="idMessage")
	private Messages idmessage;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User idUser;
	
	
	
	public int getIdReponse() {
		return idReponse;
	}
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDatePost() {
		return datePost;
	}
	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}
	public Date getDateEdit() {
		return dateEdit;
	}
	public void setDateEdit(Date dateEdit) {
		this.dateEdit = dateEdit;
	}
	public Messages getIdmessage() {
		return idmessage;
	}
	public void setIdmessage(Messages idmessage) {
		this.idmessage = idmessage;
	}
	public User getIdUser() {
		return idUser;
	}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	
}
