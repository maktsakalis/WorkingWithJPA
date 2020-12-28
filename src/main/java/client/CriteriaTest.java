/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Guide;
import entity.Student;
import entity.Student_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author makis
 */
public class CriteriaTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trn = em.getTransaction();

        try {
            trn.begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
            Root<Student> root = criteria.from(Student.class);

            Join<Student, Guide> guide = root.join(Student_.guide, JoinType.LEFT);
            criteria.select(root);

            TypedQuery<Student> query = em.createQuery(criteria);
//            Query query = em.createQuery("select guide from Guide as guide");
//            Query query = em.createQuery("select guide from Guide as guide join fetch guide.students students");

            List<Student> students = query.getResultList();

            for (Student obj : students) {
                System.out.println(obj);
            }

            trn.commit();
        } catch (Exception e) {
            if (trn != null) {
                trn.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

}
