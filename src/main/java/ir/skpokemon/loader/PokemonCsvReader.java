package ir.skpokemon.loader;

import ir.skpokemon.loader.model.Pokemon;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
public class PokemonCsvReader {

    private final static String SEPARATOR = ",";

    private File file;

    public PokemonCsvReader(@NonNull File file) {
        this.file = file;
    }

    public List<Pokemon> read(int skipLines) throws IOException {
        List<Pokemon> pokemons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            int counter = 0;
            int index = 1;
            while ((str = br.readLine()) != null) {
                if (counter++ < skipLines)
                    continue;
                pokemons.add(parse(str, index++));
            }
        }
        return pokemons;
    }

    private Pokemon parse(String str, long id) {
        String[] splitted = str.split(SEPARATOR);
        return new Pokemon(id, splitted[0], Long.valueOf(splitted[1]), Long.valueOf(splitted[2]));
    }
}
