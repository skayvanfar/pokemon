package ir.skpokemon.service;

import ir.skpokemon.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PokemonService {
    Page<Pokemon> getAllPokemons(Pageable pageable);
    List<Pokemon> search(String text, int page, int size);
}
