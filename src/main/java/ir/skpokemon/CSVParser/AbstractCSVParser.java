package ir.skpokemon.CSVParser;

import ir.skpokemon.model.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class AbstractCSVParser<T> implements CSVParser<T> {

    protected final static String SEPARATOR = ",";

    @Override
    public List<T> read(InputStream inputStream, int skipLines, Predicate<T> ...predicates) throws IOException {
        List<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            int counter = 0;
            while ((str = br.readLine()) != null) {
                if (counter++ < skipLines)
                    continue;
                Optional<T> optional = buildObject(str, predicates);
                if (optional.isPresent())
                    list.add(optional.get());
            }
        }
        return list;
    }

    protected abstract Optional<T> buildObject(String str, Predicate<T> ...predicates);
}
