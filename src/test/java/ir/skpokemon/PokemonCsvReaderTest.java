package ir.skpokemon;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.reader.PokemonCsvReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
public class PokemonCsvReaderTest {

    private PokemonCsvReader pokemonCsvReader;

    @Before
    public void setUp() throws Exception {
        URL fileURL = PokemonCsvReaderTest.class.getClassLoader().getResource("test.csv");
        Path path = Paths.get(Objects.requireNonNull(fileURL).toURI());
        pokemonCsvReader = new PokemonCsvReader(path.toFile());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testReadSizeOfCvs() throws IOException {
        int expectedCount = 4;
        int result = pokemonCsvReader.read(1).size();
        Assert.assertEquals(expectedCount, result);
    }

    @Test
    public void readWholeCsv() throws IOException {
        List<Pokemon> expectedList = Arrays.asList(new Pokemon(1L, "ali", 37L, 88L),
                new Pokemon(2L, "saeed", 33L, 67L),
                new Pokemon(3L, "reza", 26L, 70L),
                new Pokemon(4L, "hossein", 25L, 60L));
        List<Pokemon> result = pokemonCsvReader.read(1);
        Assert.assertEquals(expectedList, result);
    }

}