package client;

import entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EqualsAndHashCodeClient {

    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
//
//        //Student[id=2L] and Guide[id=2L] are  being managed by different EntityManager (em1 and em2)
//        EntityManager em1 = emf.createEntityManager();
//        em1.getTransaction().begin();
//
//        Student student = em1.find(Student.class, 2L);
//
//        em1.getTransaction().commit();
//        em1.close();
//
//        EntityManager em2 = emf.createEntityManager();
//        em2.getTransaction().begin();
//
//        Guide guide = em2.find(Guide.class, 1L);
//        Set<Student> students = guide.getStudents();
//
//        System.out.println(students.contains(student));
//
//        em2.getTransaction().commit();
//        em2.close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");

        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();

        Student student1 = em1.find(Student.class, 2L);

        em1.getTransaction().commit();
        em1.close();

        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();

        Student student2 = em2.find(Student.class, 2L);

        System.out.println(student1.equals(student2));

        em2.getTransaction().commit();
        em2.close();

    }
}
