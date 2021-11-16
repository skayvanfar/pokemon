package ir.skpokemon.config;

import ir.skpokemon.CSVParser.PokemonCsvReader;
import ir.skpokemon.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class AnnotationDrivenEventListener  {

    private PokemonCsvReader pokemonCsvReader;

    private PokemonRepository pokemonRepository;

    @Autowired
    public AnnotationDrivenEventListener(PokemonCsvReader pokemonCsvReader, PokemonRepository pokemonRepository) {
        this.pokemonCsvReader = pokemonCsvReader;
        this.pokemonRepository = pokemonRepository;
    }

    @EventListener(ApplicationContextEvent.class)
    public void handleContextStart() throws IOException {
        log.info("===================================");
        pokemonRepository.saveAll(pokemonCsvReader.read(1));
    }
}
