package client;

import entity.Guide;
import entity.Student;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Question2Client {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");

        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();

//        Guide guide = new Guide("2000RN10349", "Rose Ann", 4000);
        Student student = em1.find(Student.class, 1L);

        Guide guide = em1.find(Guide.class, 1L);
        Set<Student> students = guide.getStudents();

        System.out.println(students.contains(student));

//        em1.persist(guide);
        em1.getTransaction().commit();
        em1.close();
//
//        EntityManager em2 = emf.createEntityManager();
//        em2.getTransaction().begin();
//
//        Guide mergedGuide = em2.merge(guide);
//        mergedGuide.addStudent(new Student("2015JR50244", "Jason Bird"));
//        mergedGuide.addStudent(new Student("2015LK50878", "Lisa Mizuki"));
//
//        em2.getTransaction().commit();
//        em2.close();
        emf.close();
    }

}
