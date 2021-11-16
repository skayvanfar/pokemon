package ir.skpokemon.CSVParser;

import java.io.IOException;
import java.util.List;

public interface CSVParser<T> {
     List<T> read(int skipLines) throws IOException;
}
