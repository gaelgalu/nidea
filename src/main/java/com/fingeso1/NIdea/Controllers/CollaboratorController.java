package com.fingeso1.NIdea.Controllers;

import com.fingeso1.NIdea.Models.Collaborator;
import com.fingeso1.NIdea.Models.Idea;
import com.fingeso1.NIdea.Repositories.CollaboratorRepository;
import com.fingeso1.NIdea.Repositories.IdeaRepository;

import java.util.*;
// import org.bson.types.Integer;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/collaborators")
public class CollaboratorController {
	@Autowired
	private CollaboratorRepository collaborator_repository;
	@Autowired
	private IdeaRepository idea_repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Collaborator> getAllCollaborators() {
  		return collaborator_repository.findAll();
  	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Collaborator getCollaboratorById(@PathVariable("_id") String _id) {
  		return collaborator_repository.findBy_id(_id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Collaborator createCollaborator(@RequestBody Collaborator collaborator){
		this.collaborator_repository.save(collaborator);
		return collaborator;
	}
}