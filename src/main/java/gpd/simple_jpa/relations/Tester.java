package gpd.simple_jpa.relations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

		EntityManager em = emf.createEntityManager();

		//One to One Mapping
		User user = new User();
		user.setFirstname("guru");
		user.setLastname("J S");
		
		Address address = new Address();
		address.setCity("El Monte");
		address.setState("CA");
		address.setStreet("BA");
		address.setZipcode(123212);
		
		em.getTransaction().begin();
		em.persist(address);
		user.setAddress(address);
		em.persist(user);
		em.getTransaction().commit();
		
		em.close();
		
		
		
	}

}
