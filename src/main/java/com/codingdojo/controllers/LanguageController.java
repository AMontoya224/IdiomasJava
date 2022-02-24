package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Language;
import com.codingdojo.services.LanguageService;

@Controller
@RequestMapping( "/languages/" )
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController( LanguageService languageService ) {
		this.languageService = languageService;
	}
	
	@RequestMapping( value="", method=RequestMethod.GET )
	public String index( Model model, @ModelAttribute("language") Language language ) {
		List<Language> languagesList = languageService.selectAllFromLanguages();
		model.addAttribute( "languagesList", languagesList );
		
		return "index.jsp";
	}
	
	@RequestMapping( value="/register", method=RequestMethod.POST )
	public String register( @Valid @ModelAttribute("language") Language language, BindingResult result, Model model ) {
		if( result.hasErrors() ) {
			List<Language> languagesList = languageService.selectAllFromLanguages();
			model.addAttribute( "languagesList", languagesList );
			return "index.jsp";
		}
		languageService.insertIntoLanguages(language);
		return "redirect:/languages/";
	}
	
	@RequestMapping( value="/edit/{id}", method=RequestMethod.GET )
	public String edit( @PathVariable("id") int id, Model model, @ModelAttribute("language") Language language ) {
		Language languageEncontrado = languageService.selectFromLanguagesWhereId(id);
		model.addAttribute( "language", languageEncontrado );
		
		return "edit.jsp";
	}
	
	@RequestMapping( value="/{id}", method=RequestMethod.GET )
	public String show(@PathVariable("id") int id, Model model ) {
		Language languageEncontrado = languageService.selectFromLanguagesWhereId(id);
		model.addAttribute( "language", languageEncontrado );
		
		return "show.jsp";
    }
	
	@RequestMapping( value="/update", method=RequestMethod.PUT )
	public String update(@Valid @ModelAttribute("language") Language language, Model model, BindingResult result) {
        if (result.hasErrors()) {
        	Language expenseEncontrado = languageService.selectFromLanguagesWhereId(language.getId());
    		model.addAttribute( "language", expenseEncontrado );
            return "edit.jsp";
        } 
        else {
        	languageService.updateLanguage(language);
            return "redirect:/languages/";
        }
    }
	
	@RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE )
	public String delete( @PathVariable("id") int id ) {
		languageService.deleteFromLanguage(id);
		return "redirect:/languages/";
	}
}
