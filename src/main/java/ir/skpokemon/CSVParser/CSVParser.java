package ir.skpokemon.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface CSVParser<T> {
     List<T> read(InputStream inputStream,int skipLines) throws IOException;
}
