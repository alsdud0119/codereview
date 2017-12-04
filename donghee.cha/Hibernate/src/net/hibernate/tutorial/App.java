package net.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.hibernate.tutorial.model.User;
import net.hibernate.tutorial.utils.HibernateUtil;

public class App {
	public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        User user = new User();
        user.setEmail("cath@gmail.com");
        user.setFirstName("donghee");
        user.setLastName("Cho");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("Insert completed");
     
        session.close();
        sessionFactory.close();
    }
}
