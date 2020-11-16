package com.demente.ideas.app.adapters.mongodb.word.repositories;

import com.demente.ideas.app.adapters.mongodb.word.entities.WordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WordRepository extends MongoRepository<WordEntity, String> {
    Optional<Object> findByWord(String word);
}
