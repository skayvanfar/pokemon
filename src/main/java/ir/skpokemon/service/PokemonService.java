package ir.skpokemon.service;

import ir.skpokemon.model.Pokemon;

import java.util.List;

public interface PokemonService {
    Iterable<Pokemon> getPokemons();
    List<Pokemon> search(String text, int page, int size);
}
