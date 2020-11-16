package com.demente.ideas.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class WordCreation {
    private String word;
    private String meaning;
    private String examples;
    private String tags;
}
