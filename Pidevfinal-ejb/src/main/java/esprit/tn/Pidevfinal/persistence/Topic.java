package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Topic
 *
 */
@Entity

public class Topic implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTopic;
	
	@Column
	private String sujet;
	
	@Column
	private String contenu;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastpost;
	
	@ManyToOne
	@JoinColumn(name="idCreateur")
	private User idCreateur;


	@OneToMany(mappedBy="topic",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Messages> Messages;
	
	@ManyToOne
	@JoinColumn(name="idSousCategory")
	private SousCategory sousCategory;
	

	
	
	public int getIdTopic() {
		return idTopic;
	}
	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public SousCategory getSousCategory() {
		return sousCategory;
	}
	public void setSousCategory(SousCategory sousCategory) {
		this.sousCategory = sousCategory;
	}
	public User getIdCreateur() {
		return idCreateur;
	}
	public void setIdCreateur(User idCreateur) {
		this.idCreateur = idCreateur;
	}
	public Date getLastpost() {
		return lastpost;
	}
	public void setLastpost(Date lastpost) {
		this.lastpost = lastpost;
	}
	public List<Messages> getMessages() {
		return Messages;
	}
	public void setMessages(List<Messages> messages) {
		Messages = messages;
	}
	
	
	
}
