package ir.skpokemon.CSVParser;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public abstract class AbstractCSVParser<T> implements CSVParser<T> {

    protected final static String SEPARATOR = ",";

    @Override
    public List<T> read(InputStream inputStream, int skipLines, Set<Predicate<T>> predicates, Set<UnaryOperator<T>> unaryOperators) throws IOException {
        List<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            int counter = 0;
            while ((str = br.readLine()) != null) {
                if (counter++ < skipLines)
                    continue;
                Optional<T> optional = buildObject(str, predicates, unaryOperators);
                if (optional.isPresent())
                    list.add(optional.get());
            }
        }
        return list;
    }

    protected abstract Optional<T> buildObject(String str, Set<Predicate<T>> predicates, Set<UnaryOperator<T>> unaryOperators);
}
