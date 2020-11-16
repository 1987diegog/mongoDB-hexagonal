package com.demente.ideas.app.adapters.mongodb;

import com.demente.ideas.app.adapters.mongodb.word.WordSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseSeederService {

    private WordSeederService wordSeederService;

    @Autowired
    public DatabaseSeederService(WordSeederService wordSeederService) {
        this.wordSeederService = wordSeederService;
        this.seedDatabase();
    }

    public void seedDatabase() {
        this.wordSeederService.seedDatabase();
    }

    public void deleteAll() {
        this.wordSeederService.deleteAll();
    }

    public void reSeedDatabase() {
        this.deleteAll();
        this.seedDatabase();
    }
}
