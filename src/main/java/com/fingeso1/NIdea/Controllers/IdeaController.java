package com.fingeso1.NIdea.Controllers;

import com.fingeso1.NIdea.Models.*;
import com.fingeso1.NIdea.Repositories.CommentaryRepository;
import com.fingeso1.NIdea.Utils.IncrementId;
import com.fingeso1.NIdea.Repositories.IdeaRepository;
import com.fingeso1.NIdea.Repositories.CollaboratorRepository;

import java.util.*;
import java.io.*;
import java.text.*;
import java.text.Normalizer;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.xml.stream.events.Comment;

@RestController
@RequestMapping(value = "/ideas")
@CrossOrigin(origins = "*")
public class IdeaController {
	@Autowired
	private IdeaRepository idea_repository;
	@Autowired
	private CollaboratorRepository collaborator_repository;
	@Autowired
	private CommentaryRepository commentary_repository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Idea> getAllIdeas() {
  		return idea_repository.findAll();
  	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public Idea createIdea(@Valid @RequestBody IdeaRequest ideaRequest){

		IncrementId increment = new IncrementId();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		ArrayList<String> listaTags = new ArrayList<String>(Arrays.asList(ideaRequest.getTags().split(",")));
		Idea idea = new Idea(increment.getIncrementId(idea_repository), ideaRequest.getTitle(), ideaRequest.getContent(), ideaRequest.getAuthor(), listaTags, 0, new ArrayList<Commentary>(), format.format(new Date()));
		Collaborator c = collaborator_repository.findBy_id(idea.getAuthor());
		ArrayList<Idea> list = c.getPublishedIdeas();
		list.add(idea);
		c.setPublishedIdeas(list);
		collaborator_repository.save(c);
		return idea_repository.save(idea);
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public List<Idea> filterIdea(@Valid @RequestParam("tag") String tag){
		List<Idea> ideas = idea_repository.findAll();
		List<Idea> filteredIdeas = new ArrayList<Idea>();

		String tagCleaned = Normalizer.normalize(tag.toLowerCase(), Normalizer.Form.NFD);
		tagCleaned = tagCleaned.replaceAll("[^\\p{ASCII}]", "");

		for (Idea idea : ideas){
			List<String> tags = idea.getTags();
			for (String tagOnIdea : tags){
				String strToCompare = Normalizer.normalize(tagOnIdea.toLowerCase(), Normalizer.Form.NFD);
				strToCompare = strToCompare.replaceAll("[^\\p{ASCII}]", "");

				if (strToCompare.compareTo(tagCleaned) == 0){
					filteredIdeas.add(idea);
				}
			}
		}

		return filteredIdeas;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public List<Idea> searchTitleIdea(@Valid @RequestParam("title") String title){
		List<Idea> ideas = idea_repository.findAll();
		List<Idea> ideasSearched = new ArrayList<Idea>();

		String titleCleaned = Normalizer.normalize(title.toLowerCase(), Normalizer.Form.NFD);
		titleCleaned = titleCleaned.replaceAll("[^\\p{ASCII}]", "");

		for (Idea idea : ideas){
			String titleIdeaToCompare = Normalizer.normalize(idea.getTitle().toLowerCase(), Normalizer.Form.NFD);
			titleIdeaToCompare = titleIdeaToCompare.replaceAll("[^\\p{ASCII}]", "");

			if (titleIdeaToCompare.contains(titleCleaned)){
				ideasSearched.add(idea);
			}
		}

		return ideasSearched;
	}

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public Commentary createCommentary(@Valid @RequestBody CommentaryRequest commentaryRequest){

		IncrementId increment = new IncrementId();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		Commentary commentary = new Commentary(increment.getIncrementId(commentary_repository), commentaryRequest.getBody(), commentaryRequest.getIdea(), commentaryRequest.getAuthor(), format.format(new Date()));
		Idea i =idea_repository.findBy_id(commentary.getIdea());
		Collaborator c = collaborator_repository.findBy_id(i.getAuthor());
		ArrayList<Commentary> list2 = i.getPublishedCommentaries();
		list2.add(commentary);
		i.setPublishedCommentaries(list2);
		c.updateIdea(i);
		idea_repository.save(i);
		commentary_repository.save(commentary);
		collaborator_repository.save(c);
		return commentary;
	}



	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public Idea searchIdea(@PathVariable("_id") String _id){
		return idea_repository.findBy_id(_id);
	}


	@RequestMapping(value = "/like/{id}/{author}", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public Idea giveLike(@PathVariable("id") String id, @PathVariable("author") String author){
		Idea idea = idea_repository.findBy_id(id);
		Collaborator c = collaborator_repository.findBy_id(author);
		if(!c.getLikedIdeas().contains(idea.get_id())){
			idea.setLikes(idea.getLikes() + 1);
			idea_repository.save(idea);
			List<String> l = c.getLikedIdeas();
			l.add(idea.get_id());
			c.setLikedIdeas(l);
			collaborator_repository.save(c);
			return idea;
		}
		else{
			idea.setLikes(idea.getLikes()-1);
			idea_repository.save(idea);
			List<String> l = c.getLikedIdeas();
			l.remove(idea.get_id());
			c.setLikedIdeas(l);
			collaborator_repository.save(c);
			return idea;
		}
	}

}