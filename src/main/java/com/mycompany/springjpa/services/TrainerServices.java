/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springjpa.services;

import com.mycompany.springjpa.dao.TrainerDAO;
import com.mycompany.springjpa.entities.Trainer;

import java.util.List;

/**
 *
 * @author thanosparaskevas
 */
public class TrainerServices {

    public List<Trainer> getAllTrainers() {
        TrainerDAO tdao = new TrainerDAO();

        return tdao.getTrainers();
    }

    public boolean InsertStudent(Trainer st) {
        TrainerDAO trDao = new TrainerDAO();
        if (trDao.InsertStudentJPA(st)) {
            return true;
        }
        return false;
    }

    public void deleteTrainer(int trainerId) {
        TrainerDAO trDao = new TrainerDAO();
        trDao.deleteById(trainerId);
    }

    public void updateTrainer(Trainer tr) {
        TrainerDAO trDao = new TrainerDAO();
        trDao.update(tr);
    }

    public Trainer getTrainerbyID(int trainerId) {
        TrainerDAO trDao = new TrainerDAO();
        Trainer tr = trDao.findById(trainerId);

        return tr;
    }
}
