package hibernate1;

import java.util.Date;

import org.hibernate.Session;

public class TestHibernate {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		EmployeeEntity emp = new EmployeeEntity();
		emp.setName("Aneesh");
		emp.setAge(20);
		emp.setDob(new Date());
		emp.setStreetName("Kolshet Road");
		session.save(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
	}
}
