package ir.skpokemon.service;

import ir.skpokemon.PokemonCsvReader;
import ir.skpokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Service
public class PokemonService {

    private PokemonCsvReader pokemonCsvReader;

    @Autowired
    public PokemonService(PokemonCsvReader pokemonCsvReader) {
        this.pokemonCsvReader = pokemonCsvReader;
    }

    public List<Pokemon> getPokemons() throws IOException {
        return pokemonCsvReader.read(1);
    }
}
