package ir.skpokemon.service;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
