package ir.skpokemon.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface CSVParser<T> {
     List<T> read(InputStream inputStream, int skipLines, Set<Predicate<T>> predicates, Set<UnaryOperator<T>> unaryOperators) throws IOException;
}
