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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 *
 * @author makis
 */
public class QueryTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {
            txn.begin();
//            CriteriaBuilder builder = em.getCriteriaBuilder();
//            CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//
//            Root<Student> root = criteria.from(Student.class);
//            Path<String> name = root.get(Student_.name);
//
//            criteria.where(builder.like(name, "L%"));
//            criteria.select(root);
//
////            Query query = em.createQuery("select s from Student as s");
////            Query query = em.createNativeQuery("select * from Student", Student.class);
//            TypedQuery<Student> query = em.createQuery(criteria);
//
//            List<Student> students = query.getResultList();
//            for (Student student : students) {
//                System.out.println(student);
//            }

            Guide guide1 = em.find(Guide.class, 2L);
            guide1.setSalary(20000);

            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
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
