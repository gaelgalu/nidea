package com.fingeso1.NIdea.Utils;

import com.fingeso1.NIdea.Models.*;
import com.fingeso1.NIdea.Repositories.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.*;

public class IncrementId{

	public String getIncrementId(MongoRepository repository){
		List<Model> listOfObjects = repository.findAll();

		int maxId = 0;

		for (Model object : listOfObjects){
			String actualId = object.get_id();
			if (actualId.isEmpty()==false && Integer.parseInt(actualId) > maxId){
				maxId = Integer.parseInt(actualId);
			}
		}

		return Integer.toString(maxId + 1);
	}

}