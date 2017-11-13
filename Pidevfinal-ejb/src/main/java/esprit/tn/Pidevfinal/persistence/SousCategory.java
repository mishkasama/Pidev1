package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


@Entity

public class SousCategory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSousCategory;
	
	@Column
	private String Name;
	
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category idCategory;
	
	@OneToMany(mappedBy="sousCategory",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Topic> Topics;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	
	
	
	
	public int getIdSousCategory() {
		return idSousCategory;
	}
	public void setIdSousCategory(int idSousCategory) {
		this.idSousCategory = idSousCategory;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public Category getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Category idCategory) {
		this.idCategory = idCategory;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Topic> getTopics() {
		return Topics;
	}
	public void setTopics(List<Topic> topics) {
		Topics = topics;
	}
	
	
	
	
	
}
