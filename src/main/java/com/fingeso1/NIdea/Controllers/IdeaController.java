package com.fingeso1.NIdea.Controllers;

import com.fingeso1.NIdea.Models.Idea;
import com.fingeso1.NIdea.Models.Collaborator;
import com.fingeso1.NIdea.Repositories.IdeaRepository;
import com.fingeso1.NIdea.Repositories.CollaboratorRepository;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/ideas")
public class IdeaController {
	@Autowired
	private IdeaRepository idea_repository;
	@Autowired
	private CollaboratorRepository collaborator_repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Idea> getAllIdeas() {
  		return idea_repository.findAll();
  	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createIdea(@Valid @RequestBody Idea idea){
		Collaborator c = collaborator_repository.findBy_id(idea.getAuthor());
		ArrayList<Idea> list = c.getPublishedIdeas();
		list.add(idea);
		c.setPublishedIdeas(list);
		collaborator_repository.save(c);
		idea_repository.save(idea);
	}
}