package esprit.tn.Pidevfinal.persistence;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@XmlRootElement
public class Address implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String name;
	private float laltitude;
	private float longitude;
	
	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public float getLaltitude() {
		return this.laltitude;
	}

	public void setLaltitude(float laltitude) {
		this.laltitude = laltitude;
	}   
	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
}
