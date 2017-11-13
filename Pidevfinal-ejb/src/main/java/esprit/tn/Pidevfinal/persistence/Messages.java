package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Messages implements Serializable {

	   

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;
	
	@Column
	private String contenu;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date datePost;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateEdit;
	
	@Column
	private int nbLike;
	
	@OneToMany(mappedBy="idmessage",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Reponse> Responses;

	
	@ManyToOne
	@JoinColumn(name="idTopic")
	private Topic topic;
	
	@ManyToOne
	@JoinColumn(name="idPosteur")
	private User idPosteur;
	
	
	
	
	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
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
	public int getNbLike() {
		return nbLike;
	}
	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}
	public List<Reponse> getResponses() {
		return Responses;
	}
	public void setResponses(List<Reponse> responses) {
		Responses = responses;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public User getIdPosteur() {
		return idPosteur;
	}
	public void setIdPosteur(User idPosteur) {
		this.idPosteur = idPosteur;
	}
	
	
	
	
	
	
   
}
