/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author makis
 */
public class JPQLTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trn = em.getTransaction();

        try {
            trn.begin();

//            CriteriaBuilder builder = em.getCriteriaBuilder();
//
//            CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//            Root<Student> root = criteria.from(Student.class);
//
//            Join<Student, Guide> guide = root.join(Student_.guide, JoinType.LEFT);
//            criteria.select(root);
//
//            TypedQuery<Student> query = em.createQuery(criteria);
//            Query query = em.createQuery("select guide from Guide as guide");
//            Query query = em.createQuery("select guide from Guide as guide join fetch guide.students students");
//            Student stud1 = (em.createQuery("SELECT DISTINCT s FROM Student s JOIN FETCH s.guide", Student.class)).getSingleResult();

//            Student stud1 = em.find(Student.class, 1L);
//            Student stud4 = em.find(Student.class, 4L);
//
//            Relationship rel4to1 = new Relationship(stud4, stud1, RelationshipType.HAVE_MET);
//
//            em.persist(rel4to1);
//
            TypedQuery<Student> query = em.createQuery(
                    "SELECT s FROM Student s "
                    + "JOIN FETCH s.studentRelationships rs "
                    + "JOIN FETCH rs.student rss "
                    + "JOIN FETCH rss.relatedStudentRelationships rsr "
                    + "WHERE s.id=1L and rsr.relationshipType='FRIEND'",
                    Student.class);

            Student student = query.getSingleResult();
            System.out.println("Student: " + student);
            for (Student s : student.getStudentRelationships().keySet()) {
                System.out.println("RelatedStudent: " + s);
            }


//            Student stud = students.stream().filter(s -> s.getId() == 1L).findFirst().orElse(null);
//
//            for (Relationship rel : stud.getRelatedStudentRelationships().values()) {
//                System.out.println(rel.getRelationshipType());
//            }


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
