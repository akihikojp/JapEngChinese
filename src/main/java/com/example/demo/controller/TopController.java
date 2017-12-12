package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo.domain.Language;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("")
public class TopController {

	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/top")
	public String topPage(Model model) {
		model.addAttribute("userInfo", userRepository.findALll());
		return "top";
	}
	
	@RequestMapping("/index")
	public String index(Model model, Integer id) {
		model.addAttribute("userInfo", userRepository.findById(id));
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping("/getlanguage")
	public List<Language> getLanguage() {
		return languageRepository.findALll();
	}
}