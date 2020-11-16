package com.demente.ideas.app.adapters.rest.word;


import com.demente.ideas.app.adapters.rest.LexicalAnalyzer;
import com.demente.ideas.app.domain.model.Word;
import com.demente.ideas.app.domain.model.WordCreation;
import com.demente.ideas.app.domain.services.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.stream.Stream;

@RestController
@RequestMapping(WordResource.ROOT_PATH)
public class WordResource {

    public static final String API_VERSION = "/v1";
    public static final String RESOURCE = "/words";
    public static final String ROOT_PATH = API_VERSION + RESOURCE;

    static final String SEARCH = "/search";
    static final String SEARCH_ALL = "/search/all";
    static final String ID = "/{id}";
    static final String MEANING = "/meaning";

    private WordService wordService;

    @Autowired
    public WordResource(WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping
    public Word create(@RequestBody WordCreation wordCreation) {
        return this.wordService.create(wordCreation);
    }

    @GetMapping(SEARCH + ID)
    public Word findById(@PathVariable String id) {
        return this.wordService.findById(id);
    }

    @GetMapping(SEARCH)
    public Stream<Word> findByProviderAndPriceGreaterThan(@RequestParam String q) {
        String tag = new LexicalAnalyzer().extractWithAssure(q, "tag");
        LocalDate registrationDate = new LexicalAnalyzer().extractWithAssure(q, "registrationDate", LocalDate::parse);
        return this.wordService.findByTagAndRegistrationDateGreaterThan(tag, registrationDate);
    }

    @GetMapping(SEARCH_ALL)
    public Stream<BasicWordDTO> findAll() {
        return this.wordService.findAll()
                       .map(BasicWordDTO::new);
    }
}
