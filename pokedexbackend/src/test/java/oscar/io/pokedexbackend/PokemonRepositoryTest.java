package oscar.io.pokedexbackend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import oscar.io.pokedexbackend.pokemon.Pokemon;
import oscar.io.pokedexbackend.pokemon.PokemonRepository;


@DataJpaTest
//Unit tests for PokemonRepository
public class PokemonRepositoryTest {
	
	@Autowired
	private PokemonRepository underTest;
	
	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}
	
	@Test
	void itShouldCheckNameExists() {
		String name = "Bulbasaur";
		Pokemon pokemon = new Pokemon(name, "Grass", 45, "abc", null);
		
		underTest.save(pokemon);
		
		boolean received = underTest.existsByName(name);
		assertThat(received).isTrue();
	}
	
	
	
	
}
