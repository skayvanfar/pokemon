package ir.skpokemon.service;

import ir.skpokemon.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PokemonService {
    Page<Pokemon> getAllPokemons(Pageable pageable);
    List<Pokemon> search(String text, int page, int size);
    Pokemon save(Pokemon pokemon);

    Optional<Pokemon> findById(Long id);

    void delete(Pokemon pokemon);
}
