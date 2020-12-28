/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import entity.Cat;
import entity.Dog;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author makis
 */
public class AnimalsClient {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trn = em.getTransaction();

        try {
            trn.begin();

            Cat cat = new Cat();
            cat.setName("Lucy");

            Dog dog = new Dog();
            dog.setName("Oliver");

            em.persist(cat);
            em.persist(dog);

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
