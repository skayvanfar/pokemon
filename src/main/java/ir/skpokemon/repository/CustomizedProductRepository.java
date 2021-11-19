package ir.skpokemon.repository;

import ir.skpokemon.model.Pokemon;

import java.util.List;

public interface CustomizedProductRepository {
    List<Pokemon> search(String terms, int page, int size);
}
