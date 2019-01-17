package com.fingeso1.NIdea.Repositories;

import com.fingeso1.NIdea.Models.Desafio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*")
public interface DesafioRepository extends MongoRepository<Desafio, String> {
}
