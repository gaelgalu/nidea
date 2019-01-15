package com.fingeso1.NIdea.Repositories;

import com.fingeso1.NIdea.Models.Idea;
import com.fingeso1.NIdea.Repositories.IdeaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface IdeaRepository extends MongoRepository<Idea, String> {
    Idea findBy_id(String _id);
}