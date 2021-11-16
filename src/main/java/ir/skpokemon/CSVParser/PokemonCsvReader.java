package ir.skpokemon.CSVParser;

import ir.skpokemon.model.Pokemon;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Created by sad.kayvanfar on 11/16/2021.
 */
@Slf4j
@Component
public class PokemonCsvReader extends AbstractCSVParser<Pokemon> {

    @Override
    protected Optional<Pokemon> buildObject(String str, @NonNull Set<Predicate<Pokemon>> predicates, @NonNull Set<UnaryOperator<Pokemon>> unaryOperators) {
        String[] splitted = str.split(SEPARATOR);
        Pokemon pokemon = new Pokemon(null, splitted[0], Long.valueOf(splitted[1]), Long.valueOf(splitted[2]));

        boolean result = true;
        for (Predicate<Pokemon> predicate : predicates) {
            result = predicate.test(pokemon);
        }
        if (result) {
            for (UnaryOperator<Pokemon> pokemonUnaryOperator : unaryOperators) {
                pokemon = pokemonUnaryOperator.apply(pokemon);
            }
            return Optional.of(pokemon);
        } else
            return Optional.ofNullable(null);
    }
}
