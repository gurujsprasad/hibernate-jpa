package gpd.simple_jpa.simple;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		
		
		EntityManager em = emf.createEntityManager();
		
		//insert in to table
		
		/*Employee e = new Employee();
		e.setCity("Bangalore");
		e.setEmail("nikki@gmail.com");
		e.setFirstname("nikhil");
		e.setLastname("BN");
		
		//insert in to table
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();*/
		
		
		//Find by ID
		
		/*
		Employee e = em.find(Employee.class, "9eb761f0-fb27-415b-950d-29b517b161c3");
		System.out.println("========================================================================");
		System.out.println(e.toString());*/
		
		//Update by Id
		
		/*
		Employee e = em.find(Employee.class, "9eb761f0-fb27-415b-950d-29b517b161c3");
		e.setCity("LosAngeles");
		em.getTransaction().begin();
		e = em.merge(e);
		System.out.println(e.toString());
		em.getTransaction().commit();*/
		
		
		//Delete by ID
		
		/*Employee e = em.find(Employee.class, "9eb761f0-fb27-415b-950d-29b517b161c3");
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();*/
		
		
		//FInd all from a table
		TypedQuery<Employee> te = em.createQuery("select e from Employee e",Employee.class);
		List<Employee> employees= te.getResultList();
		
		System.out.println(employees);
		
		
		//Find by some specific column, example email
		
		//with out setting query param
		
		//TypedQuery<Employee> tm = em.createQuery("select e from Employee e where e.email = 'gautham@gmail.com'",Employee.class);
		
		//with setting query param
		TypedQuery<Employee> tm = em.createNamedQuery("Employee.findByEmail",Employee.class);
		tm.setParameter("pemail", "gautham@gmail.com");
		List<Employee> employeesWithEmail= tm.getResultList();
		
		System.out.println(employeesWithEmail);
		
		
		em.close();
		emf.close();
		//if you close emf, then the tables will be created and dropped, so comment it
		//emf.close();
	}

}
