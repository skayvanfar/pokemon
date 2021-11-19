package ir.skpokemon.repository;

import ir.skpokemon.model.Pokemon;
import org.hibernate.search.mapper.orm.Search;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedProductRepositoryImpl implements CustomizedProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Pokemon> search(String terms, int page, int size) {
        return Search.session(em).search(Pokemon.class)
                .where(f -> f.match()
                        .fields("name")
                        .matching(terms))
                .fetchHits(page, size);
    }



}
