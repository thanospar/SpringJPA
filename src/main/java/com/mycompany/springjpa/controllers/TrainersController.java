package com.mycompany.springjpa.controllers;

import com.mycompany.springjpa.entities.Trainer;
import com.mycompany.springjpa.services.TrainerServices;
import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TrainersController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {

        return "index";
    }

    @RequestMapping(value = "/trainers", method = RequestMethod.GET)
    public String getAllTrainers(ModelMap model) {
        TrainerServices trs = new TrainerServices();
        List<Trainer> list = trs.getAllTrainers();

        model.addAttribute("list", list);
        return "trainers";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        Trainer trainer = new Trainer();
        model.addAttribute("trainer", trainer);
        return "register";
    }

    /*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
     */
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public String save(@Valid Trainer tr, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "register";
        }

        TrainerServices trs = new TrainerServices();

        if (trs.InsertStudent(tr)) {
            model.addAttribute("success", "Inserted");

            return "success";
        } else {
            model.addAttribute("success", "Not Inserted");
        }
        return "success";
    }

    /*
	 * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = {"/delete-{trainerId}-trainer"}, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int trainerId) {

        TrainerServices trs = new TrainerServices();
        trs.deleteTrainer(trainerId);
        return "redirect:/trainers";
    }

    @RequestMapping(value = {"/edit-{trainerId}-trainer"}, method = RequestMethod.GET)
    public String editEmployee(ModelMap model, @PathVariable int trainerId) {
        TrainerServices trs = new TrainerServices();
        Trainer tr = trs.getTrainerbyID(trainerId);
        model.addAttribute("trainer", tr);

        return "update";
    }

    @RequestMapping(value = {"/edit-{trainerId}-trainer"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid Trainer tr, BindingResult result,
            ModelMap model, @PathVariable int trainerId) {
        TrainerServices trs = new TrainerServices();
        if (result.hasErrors()) {
            return "trainers";
        }

        trs.updateTrainer(tr);

        model.addAttribute("success", "Trainer " + tr.getFirstName() + " updated successfully");
        return "success";
    }

}
