package com.demente.ideas.app.domain.persistence_ports.word;

import com.demente.ideas.app.domain.model.Word;
import com.demente.ideas.app.domain.model.WordCreation;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.stream.Stream;

@Repository
public interface WordPersistence {

    Word create(WordCreation articleCreation);

    Word findById(String id);

    Stream<Word> findByTagAndRegistrationDateGreaterThan(String tag, LocalDate registrationDate);

    Stream<Word> findAll();
}
