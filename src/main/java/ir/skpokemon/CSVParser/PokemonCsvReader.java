package ir.skpokemon.CSVParser;

import ir.skpokemon.model.Pokemon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
@Component
public class PokemonCsvReader extends AbstractCSVParser<Pokemon> {

    @Override
    protected Optional<Pokemon> buildObject(String str, Predicate<Pokemon> ...predicates) {
        String[] splitted = str.split(SEPARATOR);
        Pokemon pokemon = new Pokemon(null, splitted[0], Long.valueOf(splitted[1]), Long.valueOf(splitted[2]));
        AtomicBoolean result = new AtomicBoolean(true);
        Arrays.stream(predicates).forEach(predicate -> result.set(predicate.test(pokemon)));
        if (result.get())
            return Optional.of(pokemon);
        else
            return Optional.ofNullable(null);
    }
}
