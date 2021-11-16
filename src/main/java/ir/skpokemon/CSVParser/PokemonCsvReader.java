package ir.skpokemon.CSVParser;

import ir.skpokemon.model.Pokemon;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
@Component
public class PokemonCsvReader extends AbstractCSVParser<Pokemon> {


    public PokemonCsvReader(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    @Override
    protected Pokemon buildObject(String str) {
        String[] splitted = str.split(SEPARATOR);
        return new Pokemon(null, splitted[0], Long.valueOf(splitted[1]), Long.valueOf(splitted[2]));
    }
}
