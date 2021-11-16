package ir.skpokemon.controller;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
@RestController
@RequestMapping("/v1/pokemon")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Pokemon>> getList() throws IOException {
        var pokemons = pokemonService.getPokemons();
        return new ResponseEntity<>((pokemons), HttpStatus.OK);
    }
}
