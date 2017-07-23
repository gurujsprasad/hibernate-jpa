package gpd.simple_jpa.simple;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "Employee.findByEmail", query = "select e from Employee e where e.email =:pemail"),
		@NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
		
		
})


public class Employee {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	private String firstname;
	private String lastname;
	private String city;
	
	//do give the properties for the column like size, uniqueness etc
	@Column (columnDefinition = "VARCHAR(100)", unique=true)
	private String email;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city
				+ ", email=" + email + "]";
	}

	public Employee () {
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
