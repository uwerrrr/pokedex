package oscar.io.pokedexbackend.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	// JpaRepository<data type, id type>
}
