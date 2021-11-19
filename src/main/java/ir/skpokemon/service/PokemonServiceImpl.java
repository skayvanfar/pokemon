package ir.skpokemon.service;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Page<Pokemon> getAllPokemons(Pageable pageable) {
        return pokemonRepository.findAll(pageable);
    }

    public List<Pokemon> search(String text, int page, int size) {
        return pokemonRepository.search(text, page, size);
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

    @Override
    public void delete(Pokemon pokemon) {
        pokemonRepository.delete(pokemon);
    }

}
