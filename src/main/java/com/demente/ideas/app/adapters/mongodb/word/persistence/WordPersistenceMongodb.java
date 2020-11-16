package com.demente.ideas.app.adapters.mongodb.word.persistence;

import com.demente.ideas.app.adapters.mongodb.word.entities.WordEntity;
import com.demente.ideas.app.adapters.mongodb.word.repositories.WordRepository;
import com.demente.ideas.app.domain.exceptions.ConflictException;
import com.demente.ideas.app.domain.exceptions.NotFoundException;
import com.demente.ideas.app.domain.model.Word;
import com.demente.ideas.app.domain.model.WordCreation;
import com.demente.ideas.app.domain.persistence_ports.word.WordPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.stream.Stream;

@Repository("wordPersistence")
public class WordPersistenceMongodb implements WordPersistence {

    private WordRepository wordRepository;

    @Autowired
    public WordPersistenceMongodb(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public Word create(WordCreation wordCreation) {
        this.assertWordNotExist(wordCreation.getWord());
        return this.wordRepository
                       .save(new WordEntity(wordCreation))
                       .toWord();
    }

    public void assertWordNotExist(String word) {
        this.wordRepository
                .findByWord(word)
                .ifPresent(wordExist -> {
                    throw new ConflictException("Word exist: " + wordExist);
                });
    }

    @Override
    public Word findById(String id) {
        WordEntity wordEntity = this.wordRepository
                                        .findById(id)
                                        .orElseThrow(() -> new NotFoundException("Word id: " + id));
        return wordEntity.toWord();
    }

    @Override
    public Stream<Word> findByTagAndRegistrationDateGreaterThan(String tag, LocalDate registrationDate) {
        return this.wordRepository.findAll().stream()
                       .filter(word -> tag.equals(word.getTags()))
                       .filter(word -> registrationDate.compareTo(word.getRegistrationDate()) < 0)
                       .map(WordEntity::toWord);
    }

    @Override
    public Stream<Word> findAll() {
        return this.wordRepository.findAll().stream()
                       .map(wordEntity -> wordEntity.toWord());
    }
}
