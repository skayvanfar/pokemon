package ir.skpokemon.loader;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
public class CsvReaderTest {

    private CsvReader csvReader;

    @Before
    public void setUp() throws Exception {
        URL fileURL = CsvReaderTest.class.getClassLoader().getResource("test.csv");
        Path path = Paths.get(Objects.requireNonNull(fileURL).toURI());
        csvReader = new CsvReader(path.toFile());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void read() throws IOException {
        int expectedCount = 4;
        int result = csvReader.read(1).size();
        Assert.assertEquals(expectedCount, result);
    }

}