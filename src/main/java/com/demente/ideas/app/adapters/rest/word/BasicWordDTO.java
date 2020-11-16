package com.demente.ideas.app.adapters.rest.word;

import com.demente.ideas.app.domain.model.Word;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BasicWordDTO {
    private String word;
    private String meaning;

    public BasicWordDTO(Word word) {
        this.word = word.getWord();
        this.meaning = word.getMeaning();
    }
}
