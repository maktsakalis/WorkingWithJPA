package client;

import entity.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Question1Client {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            Message m = em.find(Message.class, 1L); //1
            m = em.merge(m); //2
            em.detach(m); //3
            em.remove(m); //4
            m = em.merge(m); //5
            System.out.println(em.contains(m)); //6

//            Guide guide = em.find(Guide.class, 2L);
//            em.detach(guide);
//            System.out.println(guide.getStudents().size());
            em.getTransaction().commit(); //7
        } finally {
            em.close();
            emf.close();
        }
    }
}
