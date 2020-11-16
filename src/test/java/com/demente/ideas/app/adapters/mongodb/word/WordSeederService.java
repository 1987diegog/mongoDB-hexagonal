package com.demente.ideas.app.adapters.mongodb.word;

import com.demente.ideas.app.adapters.mongodb.word.entities.WordEntity;
import com.demente.ideas.app.adapters.mongodb.word.repositories.WordRepository;
import com.demente.ideas.app.domain.model.WordCreation;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class WordSeederService {

    @Autowired
    private WordRepository wordRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Word Seeder -------");
        WordEntity[] words = {
                new WordEntity(WordCreation.builder()
                                       .word("coyuntural")
                                       .meaning("La idea de coyuntura alude a la sumatoria de circunstancias y factores que inciden sobre algo en un cierto momento. El concepto puede asociarse a la noción de contexto en su sentido más amplio")
                                       .examples("\"Debido a la coyuntura económica, las empresas no están realizando inversiones en el país\", "
                                                         + "\"El fútbol local no puede escapar de la coyuntura nacional\", "
                                                         + "\"Los analistas coinciden en que la coyuntura política de España es compleja\"")
                                       .tags("\"léxico\"")
                                       .build()),
                new WordEntity(WordCreation.builder()
                                       .word("léxico")
                                       .meaning("Léxico es el vocabulario de un idioma o de una región, el diccionario de una lengua o el caudal de modismos y voces de un autor")
                                       .examples("\"Ese no es el léxico apropiado para un niña de diez años\", "
                                                         + "\"Un profesional de las ciencias de la comunicación debe manejar un léxico acorde a su responsabilidad social\", "
                                                         + "\"El léxico de los adolescentes actuales parece limitarse a unas pocas palabras\"")
                                       .tags("\"léxico\"")
                                       .build()),
                new WordEntity(WordCreation.builder()
                                       .word("analogía")
                                       .meaning("Emana del latín analogía aunque con origen más remoto en un vocablo griego que puede traducirse como \"semejanza\" o \"proporción\". "
                                                        + "Ese término griego, se encontraba conformado por tres partes claramente diferenciadas: "
                                                        + "• El prefijo \"ana-\", que es equivalente a \"sobre o contra\". "
                                                        + "• El vocablo \"logos\", que puede traducirse como \"palabra o razón\". "
                                                        + "• El sufijo \"-ia\", que se usa para indicar \"cualidad\".")
                                       .examples("\"Creo que el público no entendió mi analogía entre el revolver y el micrófono\","
                                                         + " \"El intendente sorprendió al trazar una analogía entre la situación que se vive en el pueblo y la registrada en los principales centros económicos del mundo\", "
                                                         + "\"No me gustó la analogía que hiciste entre mi carrera y la trayectoria de Gómez\".")
                                       .tags("\"léxico\", \"término\"")
                                       .build())
        };

        this.wordRepository.saveAll(Arrays.asList(words));
    }

    public void deleteAll() {
        this.wordRepository.deleteAll();
    }
}
