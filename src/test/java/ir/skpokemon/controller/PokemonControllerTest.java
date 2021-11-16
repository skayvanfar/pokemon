package ir.skpokemon.controller;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.service.PokemonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService;

    @Before
    public void setUp() throws Exception {
        Mockito.when(pokemonService.getPokemons()).thenReturn(
                Arrays.asList(new Pokemon(1L, "ali", 37L, 88L)
                        ,new Pokemon(2L, "saeed", 33L, 67L)));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetList() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/v1/pokemon/")
                .accept(MediaType.APPLICATION_JSON);

         this.mockMvc.perform(request).andExpect(status().isOk()).andDo(print()).andExpect(content()
                 .json("[{\"id\":1,\"name\":\"ali\",\"age\":37,\"wight\":88},{\"id\":2,\"name\":\"saeed\",\"age\":33,\"wight\":67}]")).andReturn();
    }
}