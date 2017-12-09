package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Language;
import com.example.demo.repository.LanguageRepository;

@Controller
@RequestMapping("")
public class TopController {

	@Autowired
	private LanguageRepository languageRepository;
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping("/getlanguage")
	public List<Language> getLanguage() {
		return languageRepository.findALll();
	}
}