package client;

import entity.Customer;
import entity.Passport;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneClient {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passport passport = new Passport("925076473");
        Customer customer = new Customer("Nicole Scott", passport);

        em.persist(customer);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
