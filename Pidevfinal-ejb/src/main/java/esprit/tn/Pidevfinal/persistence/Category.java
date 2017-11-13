package esprit.tn.Pidevfinal.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;
	@Column
	private String NameCategory;
	
	@OneToMany(mappedBy="idCategory",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<SousCategory> SousCategories;
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return NameCategory;
	}
	public void setNameCategory(String nameCategory) {
		NameCategory = nameCategory;
	}
	public List<SousCategory> getSousCategories() {
		return SousCategories;
	}
	public void setSousCategories(List<SousCategory> sousCategories) {
		SousCategories = sousCategories;
	}

	
	
 

   
}
