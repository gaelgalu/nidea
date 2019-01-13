package com.fingeso1.NIdea.Controllers;

import com.fingeso1.NIdea.Models.Idea;
import com.fingeso1.NIdea.Repositories.IdeaRepository;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ideas")
public class IdeaController {
	@Autowired
	private IdeaRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Idea> getAllIdeas() {
  		return repository.findAll();
  	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Idea createIdea(@Valid @RequestBody Idea idea){
		repository.save(idea);
		return idea;
	}
}