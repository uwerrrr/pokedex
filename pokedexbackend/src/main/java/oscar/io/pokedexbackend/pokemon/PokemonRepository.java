package oscar.io.pokedexbackend.pokemon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	// JpaRepository<data type, id type>
	
	 List<Pokemon> findByType(String type);
	 List<Pokemon> findByHpGreaterThanEqual(Integer minHp);
	 boolean existsByName(String name);
}
