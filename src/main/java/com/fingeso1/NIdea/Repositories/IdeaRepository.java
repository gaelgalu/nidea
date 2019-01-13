package com.fingeso1.NIdea.Repositories;

import com.fingeso1.NIdea.Models.Idea;
import com.fingeso1.NIdea.Repositories.IdeaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface IdeaRepository extends MongoRepository<Idea, String> {

}