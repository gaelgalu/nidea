package com.fingeso1.NIdea.Controllers;

import com.fingeso1.NIdea.Models.Idea;
import com.fingeso1.NIdea.Models.Collaborator;
import com.fingeso1.NIdea.Models.IdeaRequest;
import com.fingeso1.NIdea.Repositories.IdeaRepository;
import com.fingeso1.NIdea.Repositories.CollaboratorRepository;

import java.util.*;
import java.text.Normalizer;
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
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Idea> getAllIdeas() {
  		return idea_repository.findAll();
  	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public void createIdea(@Valid @RequestBody IdeaRequest ideaRequest){
		ArrayList<String> listaTags = new ArrayList<String>(Arrays.asList(ideaRequest.getTags().split(",")));
		Idea idea = new Idea(ideaRequest.get_id(),ideaRequest.getContent(), ideaRequest.getAuthor(), listaTags);
		Collaborator c = collaborator_repository.findBy_id(idea.getAuthor());
		ArrayList<Idea> list = c.getPublishedIdeas();
		list.add(idea);
		c.setPublishedIdeas(list);
		collaborator_repository.save(c);
		idea_repository.save(idea);
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Idea> filterIdea(@Valid @RequestParam("tag") String tag){
		List<Idea> ideas = idea_repository.findAll();
		List<Idea> filteredIdeas = new ArrayList<Idea>();

		// System.out.println(tag);

		String tagCleaned = Normalizer.normalize(tag.toLowerCase(), Normalizer.Form.NFD);
		tagCleaned = tagCleaned.replaceAll("[^\\p{ASCII}]", "");


		for (Idea idea : ideas){
			List<String> tags = idea.getTags();
			for (String tagOnIdea : tags){
				String strToCompare = Normalizer.normalize(tagOnIdea.toLowerCase(), Normalizer.Form.NFD);
				strToCompare = strToCompare.replaceAll("[^\\p{ASCII}]", "");

				// System.out.println("TagCleaned: " + tagCleaned + " and tagToCompare: " + strToCompare);
				if (strToCompare.compareTo(tagCleaned) == 0){
					filteredIdeas.add(idea);
				}
			}
		}

		return filteredIdeas;
	}
}