package ir.skpokemon.controller;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/pokemon")
@CrossOrigin("*")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonServiceImpl) {
        this.pokemonService = pokemonServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Pokemon>> getAllPokemons(@PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) throws IOException {
        return ResponseEntity.ok(pokemonService.getAllPokemons(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pokemon>> search(@RequestParam String text) {
        return new ResponseEntity<>(pokemonService.search(text, 0, 5), HttpStatus.OK);
    }
}
