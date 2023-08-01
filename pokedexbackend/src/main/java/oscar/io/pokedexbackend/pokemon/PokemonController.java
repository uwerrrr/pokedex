package oscar.io.pokedexbackend.pokemon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import oscar.io.pokedexbackend.exceptions.NotFoundException;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	//// POST
	@PostMapping
	public ResponseEntity <Pokemon> createPokemon(@Valid @RequestBody CreatePokemonDTO data){
		Pokemon createdPokemon = this.pokemonService.create(data);
		return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
	}
	
	//// GET (find)
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAll(){
		List<Pokemon> allPokemons = this.pokemonService.findAll();
		return new ResponseEntity<>(allPokemons, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getById(@PathVariable Long id){
		Optional<Pokemon> foundPokemon = this.pokemonService.findById(id);
		
		if (foundPokemon.isEmpty()) {
			throw new NotFoundException(String.format("Pokemon with id: %s not found", id));
		}
		return new ResponseEntity<>(foundPokemon.get(), HttpStatus.OK);
	}
	
	//// DELLETE
	// return 204 - success, no content
	@DeleteMapping("/{id}")
	public ResponseEntity<Pokemon> deleteById(@PathVariable Long id){
		boolean pokemonDeleted = this.pokemonService.deleteById(id);
		// this.postService.deleteId(id);
		
		if (!pokemonDeleted) {
			throw new NotFoundException(String.format("Pokemon with id: %s not found, could not be deleted", id));
		}
		
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	//// PATCH (update)
	@PatchMapping("/{id}")
	public ResponseEntity<Pokemon> updateById(@PathVariable Long id, @Valid @RequestBody UpdatePokemonDTO data){
		
		Optional<Pokemon> maybeUpdated = this.pokemonService.updateById(id, data);
		if(maybeUpdated.isEmpty()) {
			throw new NotFoundException(String.format("Pokemon with id: %s not found, could not be updated", id));
		}
		
		return new ResponseEntity<Pokemon>(maybeUpdated.get(), HttpStatus.OK);
	}
}
