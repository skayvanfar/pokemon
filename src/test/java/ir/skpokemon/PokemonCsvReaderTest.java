package ir.skpokemon;

import ir.skpokemon.model.Pokemon;
import ir.skpokemon.CSVParser.PokemonCsvReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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

    private InputStream inputStream;
    private PokemonCsvReader pokemonCsvReader;

    @Before
    public void setUp() throws Exception {
        URL fileURL = PokemonCsvReaderTest.class.getClassLoader().getResource("test.csv");
        Path path = Paths.get(Objects.requireNonNull(fileURL).toURI());
        inputStream = new FileInputStream(path.toFile());
        pokemonCsvReader = new PokemonCsvReader();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testReadSizeOfCvs() throws IOException {
        int expectedCount = 4;
        int result = pokemonCsvReader.read(inputStream, 1).size();
        Assert.assertEquals(expectedCount, result);
    }

    @Test
    public void readWholeCsv() throws IOException {
        List<Pokemon> expectedList = Arrays.asList(new Pokemon(null, "ali", 37L, 88L),
                new Pokemon(null, "saeed", 33L, 67L),
                new Pokemon(null, "reza", 26L, 70L),
                new Pokemon(null, "hossein", 25L, 60L));
        List<Pokemon> result = pokemonCsvReader.read(inputStream, 1);
        Assert.assertEquals(expectedList, result);
    }

    @Test
    public void readWholeCsvFilterByAgeGreaterThan30() throws IOException {
        List<Pokemon> expectedList = Arrays.asList(new Pokemon(null, "ali", 37L, 88L),
                new Pokemon(null, "saeed", 33L, 67L));
        List<Pokemon> result = pokemonCsvReader.read(inputStream, 1, pokemon -> pokemon.getAge() > 30);
        Assert.assertEquals(expectedList, result);
    }

}