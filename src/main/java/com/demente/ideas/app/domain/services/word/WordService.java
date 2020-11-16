package com.demente.ideas.app.domain.services.word;

import com.demente.ideas.app.domain.model.Word;
import com.demente.ideas.app.domain.model.WordCreation;
import com.demente.ideas.app.domain.persistence_ports.word.WordPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Stream;

@Service
public class WordService {

    private WordPersistence wordPersistence;

    @Autowired
    public WordService(WordPersistence wordPersistence) {
        this.wordPersistence = wordPersistence;
    }

    public Word create(WordCreation wordCreation) {
        return this.wordPersistence.create(wordCreation);
    }

    public Word findById(String id) {
        return this.wordPersistence.findById(id);
    }

    public Stream<Word> findByTagAndRegistrationDateGreaterThan(String tag, LocalDate localDate) {
        return this.wordPersistence.findByTagAndRegistrationDateGreaterThan(tag, localDate);
    }

    public Stream<Word> findAll() {
        return this.wordPersistence.findAll();
    }
}
