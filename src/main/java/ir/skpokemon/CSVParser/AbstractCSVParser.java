package ir.skpokemon.CSVParser;

import ir.skpokemon.model.Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCSVParser<T> implements CSVParser<T> {

    protected final static String SEPARATOR = ",";

    @Override
    public List<T> read(InputStream inputStream, int skipLines) throws IOException {
        List<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            int counter = 0;
            while ((str = br.readLine()) != null) {
                if (counter++ < skipLines)
                    continue;
                list.add(buildObject(str));
            }
        }
        return list;
    }

    protected abstract T buildObject(String str);
}
