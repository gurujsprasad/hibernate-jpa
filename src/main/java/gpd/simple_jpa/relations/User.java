package gpd.simple_jpa.relations;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	private String firstname;
	private String lastname;
	
	
	
	/*@ManyToMany
	private List<Address> address;*/
	
	/*@ManyToOne
	private Address address;
	*/
	
	
	//this is one to many mapping
	/*@OneToMany
	private List<Address> address ;
	*/
	
	//this is the relation between the user and address model
	@OneToOne
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	public User () {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
