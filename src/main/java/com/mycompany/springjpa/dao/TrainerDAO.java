/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springjpa.dao;

import com.mycompany.springjpa.entities.Trainer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;


/**
 *
 * @author thanosparaskevas
 */
public class TrainerDAO {

    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("com.mycompany_SpringJPA_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public List<Trainer> getTrainers() {

        List<Trainer> trainers = null;

//begin transaction
        em.getTransaction().begin();
        try {
            trainers = em.createNamedQuery("Trainer.findAll")
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }

        return trainers;
    }

    public Trainer findById(int trainerId) {
        Trainer trainer = em.find(Trainer.class, trainerId);
        if (trainer == null) {
            throw new EntityNotFoundException("Can't find Trainer for ID "
                    + trainerId);
        }
        return trainer;
    }

    public boolean InsertStudentJPA(Trainer s) {

        boolean completed = false;

//begin transaction
        em.getTransaction().begin();
        try {
            em.persist(s);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }

        return completed;
    }

    public void deleteById(int trainerId) {

        Trainer trainer = findById(trainerId);
        if (trainer != null) {
            em.getTransaction().begin();
            em.remove(trainer);
            em.getTransaction().commit();
        }
    }

    
     public void update(Trainer tr) {
        
         
        em.getTransaction().begin();
        em.merge(tr);
        em.getTransaction().commit();
    }
}
