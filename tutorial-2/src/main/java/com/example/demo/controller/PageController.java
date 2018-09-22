package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value="a",defaultValue="0") int a, @RequestParam(value="b",defaultValue="0") int b, String result, Model model) {
		
		String tmp = "hm";
		result = "";

		if (a > 1) {
			for (int i=1; i<a; i++) {
				tmp += "m";
			}
		}

		if (b > 1) {
			for (int i=0; i<b; i++) {
				result += " " + tmp;
			}
		} else result=tmp;
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", result);

		return "generator";
	}
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam(value="name", required=false, defaultValue="kiki") String name, Model model) {
//		model.addAttribute("name", name);
//		return "challenge";
//	}

//	@RequestMapping("/challenge/{name}")
//	public String challengePath(@PathVariable String name, Model model) {
//		model.addAttribute("name", name);
//		return "challenge";
//	}
	
	@RequestMapping (value= {"/challenge", "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()){
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		} return "challenge";
	}
}