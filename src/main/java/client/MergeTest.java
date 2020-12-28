/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Guide;
import entity.Student;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author makis
 */
public class MergeTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trn = em.getTransaction();

        trn.begin();

        Guide guide = em.find(Guide.class, 4L);
        Set<Student> students = guide.getStudents();
//        int numOfStudents = students.size();

        Student student = null;
        for (Student stud : students) {
            if (stud.getId() == 1L) {
                student = stud;
            }
        }

        trn.commit();
        em.close();

        guide.setSalary(22000);
        student.setName("Larry Bird");

        EntityManager em2 = emf.createEntityManager();
        EntityTransaction trn2 = em2.getTransaction();
        trn2.begin();

        Guide mergedGuide = em2.merge(guide);

        trn2.commit();
        em2.close();
        emf.close();
    }
}
