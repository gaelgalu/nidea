package com.fingeso1.NIdea.Repositories;

import com.fingeso1.NIdea.Models.Commentary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface CommentaryRepository extends MongoRepository<Commentary, String> {
}
