package ir.skpokemon.repository;

import ir.skpokemon.model.Pokemon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long> {
}
