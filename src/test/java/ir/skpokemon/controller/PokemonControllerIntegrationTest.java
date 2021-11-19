package ir.skpokemon.controller;

import ir.skpokemon.PokemonApplication;
import ir.skpokemon.model.Pokemon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PokemonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokemonControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllPokemones() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/pokemons",
                HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void testGetPokemonById() {
        Pokemon Pokemon = restTemplate.getForObject(getRootUrl() + "/api/v1/pokemons/1", Pokemon.class);
        System.out.println(Pokemon.getName());
        assertNotNull(Pokemon.getName());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setName("bahar");
        pokemon.setAge(54L);
        pokemon.setWight(90L);

        ResponseEntity<Pokemon> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/pokemons", pokemon, Pokemon.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(pokemon.getName(), postResponse.getBody().getName());
    }

    @Test
    public void testUpdatePokemon() {
        int id = 1;
        Pokemon pokemon = restTemplate.getForObject(getRootUrl() + "/api/v1/pokemons/" + id, Pokemon.class);
        pokemon.setName("Hamide");
        pokemon.setAge(56L);

        restTemplate.put(getRootUrl() + "/api/v1/pokemons/" + id, pokemon);

        Pokemon updatedPokemon = restTemplate.getForObject(getRootUrl() + "/api/v1/pokemons/" + id, Pokemon.class);
        assertNotNull(updatedPokemon);
        assertEquals(pokemon, updatedPokemon);
    }

    @Test
    public void testDeletePokemon() {
        int id = 2;
        Pokemon Pokemon = restTemplate.getForObject(getRootUrl() + "/api/v1/pokemons/" + id, Pokemon.class);
        assertNotNull(Pokemon);

        restTemplate.delete(getRootUrl() + "/api/v1/pokemons/" + id);

        try {
            Pokemon = restTemplate.getForObject(getRootUrl() + "/api/v1/pokemons/" + id, Pokemon.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
