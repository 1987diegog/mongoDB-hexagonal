package com.demente.ideas.app.domain.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Word {
    private String id;
    private String word;
    private String meaning;
    private LocalDate registrationDate;
    private String examples;
    private String tags;
}
