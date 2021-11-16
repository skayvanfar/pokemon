package ir.skpokemon.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Predicate;

public interface CSVParser<T> {
     List<T> read(InputStream inputStream, int skipLines, Predicate<T> ...predicates) throws IOException;
}
