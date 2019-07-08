package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Car;
import com.example.demo.services.CarServiceInput;

@Controller
@RequestMapping(value = "/car") //Every URL start with /car 
public class CarController {
	
	
		@Autowired
		CarServiceInput carServiceInput;
		
		@GetMapping(value = "/cartest")
		public String cartest() {
			return "cartest";
		}
		
		@GetMapping(value = "/securitytest")
		public String securitytest() {
			return "securitytest";
		}
		
		@GetMapping(value = "/login")
		public String login() {
			return "login";
		}
		
		
		@GetMapping(value = "/allcarsview")
		public String allcarsview(Model model) {
			model.addAttribute("object" , carServiceInput.selectAll());
			return "allcarsview";
		}
		
		@GetMapping(value="/allcarsview/{id}")//localhost:8080/allcarsview
		public String onecarsview(@PathVariable(name = "id")int id, Model model){
			
			model.addAttribute("object", carServiceInput.selectById(id));
			return "viewonecar";//allcarsview.html
		}
		
		
		@GetMapping(value="/addnewcar")//localhost:8080/car/addnewcar
		public String addcarGet(Car car)//empty car object
		{					
			return "addnewcar";//addnewcar.html
		}
		
		@PostMapping(value="/addnewcar")
		public String addcarPost(@Valid Car car, BindingResult result)//empty car object
		{		
			if(result.hasErrors()) {
				return "addnewcar";
			}
			carServiceInput.InsertNewCar(car);
			return "redirect:/car/allcarsview";
		}
		
		@GetMapping(value= "/update/{id}")
		public String updateCarGet(@PathVariable(name = "id") int id, Model model) {
			model.addAttribute("car", carServiceInput.selectById(id));
			
			return "update";
		}
		
		@PostMapping(value= "/update/{id}")
		public String updateCarPost(@PathVariable(name = "id") int id, Car car) {
			carServiceInput.updateCarById(car, id);
			return "redirect:/car/allcarsview";
		}
		
		@GetMapping(value= "/delete/{id}")
		public String deleteCarGet(@PathVariable(name = "id") int id) {
			
			carServiceInput.deleteCarById(id);
			return "redirect:/car/allcarsview";
		}
		
	
		
}
