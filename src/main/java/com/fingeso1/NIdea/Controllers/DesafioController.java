package com.fingeso1.NIdea.Controllers;

import com.fingeso1.NIdea.Models.Desafio;
import com.fingeso1.NIdea.Models.DesafioRequest;
import com.fingeso1.NIdea.Utils.IncrementId;
import com.fingeso1.NIdea.Models.Collaborator;
import com.fingeso1.NIdea.Repositories.DesafioRepository;
import com.fingeso1.NIdea.Repositories.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value= "/desafios")
public class DesafioController {
    @Autowired
    private DesafioRepository desafio_repository;
    @Autowired
    private CollaboratorRepository collaborator_repository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Desafio> getAllDesafios() {
        return desafio_repository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public void createDesafio(@Valid @RequestBody DesafioRequest desafioRequest){

        IncrementId increment = new IncrementId();
        ArrayList<String> listaTags = new ArrayList<String>(Arrays.asList(desafioRequest.getTags().split(",")));
        Desafio desafio = new Desafio(increment.getIncrementId(desafio_repository), desafioRequest.getTitle(), desafioRequest.getContent(), desafioRequest.getAuthor(), listaTags);
        Collaborator c = collaborator_repository.findBy_id(desafio.getAuthor());
        ArrayList<Desafio> list = c.getPublishedDesafios();
        System.out.println(desafio.get_id());
        list.add(desafio);
        c.setPublishedDesafios(list);
        collaborator_repository.save(c);
        desafio_repository.save(desafio);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Desafio> filterDesafio(@Valid @RequestParam("tag") String tag){
        List<Desafio> desafios = desafio_repository.findAll();
        List<Desafio> filteredDesafios = new ArrayList<Desafio>();

        String tagCleaned = Normalizer.normalize(tag.toLowerCase(), Normalizer.Form.NFD);
        tagCleaned = tagCleaned.replaceAll("[^\\p{ASCII}]", "");

        for (Desafio desafio : desafios){
            List<String> tags = desafio.getTags();
            for (String tagOnIdea : tags){
                String strToCompare = Normalizer.normalize(tagOnIdea.toLowerCase(), Normalizer.Form.NFD);
                strToCompare = strToCompare.replaceAll("[^\\p{ASCII}]", "");

                if (strToCompare.compareTo(tagCleaned) == 0){
                    filteredDesafios.add(desafio);
                }
            }
        }

        return filteredDesafios;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Desafio> searchTitleDesafio(@Valid @RequestParam("title") String title){
        List<Desafio> desafios = desafio_repository.findAll();
        List<Desafio> desafiosSearched = new ArrayList<Desafio>();

        String titleCleaned = Normalizer.normalize(title.toLowerCase(), Normalizer.Form.NFD);
        titleCleaned = titleCleaned.replaceAll("[^\\p{ASCII}]", "");

        for (Desafio desafio : desafios){
            String titleIdeaToCompare = Normalizer.normalize(desafio.getTitle().toLowerCase(), Normalizer.Form.NFD);
            titleIdeaToCompare = titleIdeaToCompare.replaceAll("[^\\p{ASCII}]", "");

            if (titleIdeaToCompare.contains(titleCleaned)){
                desafiosSearched.add(desafio);
            }
        }

        return desafiosSearched;
    }
}
