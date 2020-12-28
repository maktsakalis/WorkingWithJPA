/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Guide;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author makis
 */
public class QueryTest2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {
            txn.begin();

            Guide guide1 = em.find(Guide.class, 2L);
            Guide guide2 = (Guide) em.createQuery("select guide from Guide as guide where id=:id").setParameter("id", 2L).getSingleResult();
            Guide guide3 = (Guide) em.createQuery("select guide from Guide as guide where name=:name").setParameter("name", "MyGuide").getSingleResult();

            System.out.println(guide1);
            System.out.println(guide2);
            System.out.println(guide3);

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
