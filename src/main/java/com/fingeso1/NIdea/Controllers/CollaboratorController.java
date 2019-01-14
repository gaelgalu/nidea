package com.fingeso1.NIdea.Controllers;

import com.fingeso1.NIdea.Models.Collaborator;
import com.fingeso1.NIdea.Models.Idea;
import com.fingeso1.NIdea.Models.CollaboratorRequest;
import com.fingeso1.NIdea.Utils.IncrementId;
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
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Collaborator> getAllCollaborators() {
  		return collaborator_repository.findAll();
  	}

	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	public Collaborator getCollaboratorById(@PathVariable("_id") String _id) {
  		return collaborator_repository.findBy_id(_id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Collaborator createCollaborator(@RequestBody CollaboratorRequest collaboratorRequest){
		IncrementId increment = new IncrementId();
		Collaborator collaborator = new Collaborator(increment.getIncrementId(collaborator_repository), collaboratorRequest.getName(), collaboratorRequest.getLastname(), collaboratorRequest.getEmail(), new ArrayList<Idea>());

		// collaborator.setPublishedIdeas(new ArrayList<Idea>());
		// collaborator.set_id(increment.getIncrementId(collaborator_repository));
		this.collaborator_repository.save(collaborator);
		return collaborator;
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void updateCollaborator(Collaborator collaborator, String _id){
		Collaborator c = collaborator_repository.findBy_id(_id);
		c.setName(collaborator.getName());
		c.setEmail(collaborator.getEmail());
		c.setLastname(collaborator.getLastname());
		c.setPublishedIdeas(collaborator.getPublishedIdeas());

		collaborator_repository.save(c);
	}
}