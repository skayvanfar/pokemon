package ir.skpokemon.controller;

import ir.skpokemon.exception.ResourceNotFoundException;
import ir.skpokemon.model.Pokemon;
import ir.skpokemon.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonServiceImpl) {
        this.pokemonService = pokemonServiceImpl;
    }

    @GetMapping("/pokemons")
    public ResponseEntity<Page<Pokemon>> getAllPokemons(@PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(pokemonService.getAllPokemons(pageable));
    }

    @PostMapping("/pokemons")
    public Pokemon createEmployee(@Valid @RequestBody Pokemon pokemon) {
        return pokemonService.save(pokemon);
    }

    @GetMapping("/pokemons/{id}")
    public ResponseEntity<Pokemon> getEmployeeById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Pokemon pokemon = pokemonService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(pokemon);
    }

    @PutMapping("/pokemons/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable(value = "id") Long id, @Valid @RequestBody Pokemon pokemon) throws ResourceNotFoundException {
        Pokemon currPokemon = pokemonService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pokemon not found for this id :: " + id));

        currPokemon.setName(pokemon.getName());
        currPokemon.setAge(pokemon.getAge());
        currPokemon.setWight(pokemon.getWight());

        final Pokemon updatedEmployee = pokemonService.save(currPokemon);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Pokemon pokemon = pokemonService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pokemon not found for this id :: " + id));
        pokemonService.delete(pokemon);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pokemon>> search(@RequestParam String text) {
        return new ResponseEntity<>(pokemonService.search(text, 0, 5), HttpStatus.OK);
    }
}
