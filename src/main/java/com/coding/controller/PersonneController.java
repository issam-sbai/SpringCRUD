package com.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.coding.entity.Personne;
import com.coding.service.IpersersonneService;

@Controller
public class PersonneController {
	
	@Autowired
	IpersersonneService service;
	
	@RequestMapping("/afficherPersonnes")
	public String afficherPersonnes(Model model)
	{
		List<Personne> liste= service.selectAll();
		model.addAttribute("personnes", liste);
		
		return "personneJsp";
		
	}

	@RequestMapping("/deletePersonne")
	public String deletePersonne(@RequestParam("id") int id) {
		service.supprimer(id);
		return "redirect:/afficherPersonnes"; // Redirect back to the list after deletion
	}

	@PostMapping("/addUser")
	public String addUser(@RequestParam String nom, @RequestParam String prenom, @RequestParam int age) {
		Personne newUser = new Personne();
		newUser.setNom(nom);
		newUser.setPrenom(prenom);
		newUser.setAge(age);

		service.ajouter(newUser);

		return "redirect:/afficherPersonnes"; // Redirect to the list of users
	}

	@RequestMapping("/editPersonne")
	public String editUserForm(@RequestParam("id") int id, Model model) {
		Personne user = service.selecOne(id); // Assuming you have a method to find by ID
		if (user != null) {
			System.out.println(user.getNom());
			model.addAttribute("user", user);

			List<Personne> liste= service.selectAll();
			model.addAttribute("personnes", liste);
			return "personneJsp"; // Return the JSP for editing with the user's data
		} else {
			return "userNotFound"; // Display a separate JSP if the user is not found
		}
	}

	@PostMapping("/editUser")
	public String editUser(Personne P) {
		//Personne p = new Personne(nom,prenom,age);
		System.out.println(P.getNom()+"nom");
		service.modifier(P); // Assuming you have a method to update user
		return "redirect:/afficherPersonnes"; // Redirect to the list of users
	}


}
