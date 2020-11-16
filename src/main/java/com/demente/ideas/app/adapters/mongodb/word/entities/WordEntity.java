package com.demente.ideas.app.adapters.mongodb.word.entities;

import com.demente.ideas.app.domain.model.Word;
import com.demente.ideas.app.domain.model.WordCreation;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
@Data
@NoArgsConstructor
public class WordEntity {

    @Id
    private String id;
    private String word;
    private String meaning;
    private LocalDate registrationDate;
    private String examples;
    private String tags;

    public WordEntity(WordCreation wordCreation) {
        BeanUtils.copyProperties(wordCreation, this);
        this.id = UUID.randomUUID().toString();
        this.registrationDate = LocalDate.now();
    }

    public Word toWord() {
        Word word = new Word();
        BeanUtils.copyProperties(this, word);
        return word;
    }

    public void fromWord(Word word) {
        BeanUtils.copyProperties(word, this);
    }
}
