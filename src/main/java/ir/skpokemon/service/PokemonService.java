package ir.skpokemon.service;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.reader.PokemonCsvReader;
import ir.skpokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Iterable<Pokemon> getPokemons() throws IOException {
        return pokemonRepository.findAll();
    }
}
