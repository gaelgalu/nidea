package com.fingeso1.NIdea.Repositories;

import com.fingeso1.NIdea.Models.Collaborator;
import com.fingeso1.NIdea.Repositories.CollaboratorRepository;
// import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface CollaboratorRepository extends MongoRepository<Collaborator, String> {
  Collaborator findBy_id(String _id);
}