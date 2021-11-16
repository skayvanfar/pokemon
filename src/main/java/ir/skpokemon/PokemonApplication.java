package ir.skpokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@SpringBootApplication
public class PokemonApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokemonApplication.class, args);
    }

    @Bean
    public File file() throws URISyntaxException {
        URL fileURL = PokemonApplication.class.getClassLoader().getResource("test.csv");
        Path path = Paths.get(Objects.requireNonNull(fileURL).toURI());
        return path.toFile();
    }

    @Autowired
    @Bean
    public InputStream inputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}
