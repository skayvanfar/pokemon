package ir.skpokemon.config;

import ir.skpokemon.CSVParser.PokemonCsvReader;
import ir.skpokemon.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Component
public class AnnotationDrivenEventListener  {

    private PokemonCsvReader pokemonCsvReader;

    private PokemonRepository pokemonRepository;

    private InputStream inputStream;

    @Autowired
    public AnnotationDrivenEventListener(PokemonCsvReader pokemonCsvReader, PokemonRepository pokemonRepository, InputStream inputStream) {
        this.pokemonCsvReader = pokemonCsvReader;
        this.pokemonRepository = pokemonRepository;
        this.inputStream = inputStream;
    }

    @EventListener(ApplicationContextEvent.class)
    public void handleContextStart() throws IOException {
        log.info("===================================");
        pokemonRepository.saveAll(pokemonCsvReader.read(inputStream, 1));
    }
}
