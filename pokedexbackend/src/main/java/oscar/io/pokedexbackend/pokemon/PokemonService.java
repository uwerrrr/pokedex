package oscar.io.pokedexbackend.pokemon;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service // identyify this is service layer
@Transactional // each database updating request is a transaction
public class PokemonService {
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	///// CREATE
	public Pokemon create(CreatePokemonDTO data) {
		
		System.out.println(data.getName());
		
		Pokemon newPokemon = modelMapper.map(data, Pokemon.class);
			// modelMapper.map(source, destination type)
		
		Pokemon createdPokemon = this.pokemonRepository.save(newPokemon);
	
		return createdPokemon;
	} // return the created pokemon
	
	
	
	
	//// FIND
	// find all
	public List<Pokemon> findAll(){
		return this.pokemonRepository.findAll();
		// .findAll(): Returns all instances of the type.
			// returns empty array if none is found
	}
	
	// find by id
	public Optional<Pokemon> findById(Long id){
		Optional<Pokemon> maybePokemon = this.pokemonRepository.findById(id);
		
		return maybePokemon;
	}
	
	//// DELETE
	// delete by id
	public boolean deleteById(Long id) {
		Optional<Pokemon> maybePokemon = this.findById(id);
		
		if(maybePokemon.isEmpty()) return false;
		
		this.pokemonRepository.delete(maybePokemon.get());
		
		return true;
	} // return true if found & deleted

	
	//// UPDATE
	// update by id
	public Optional<Pokemon> updateById(Long id, UpdatePokemonDTO data){
		Optional<Pokemon> maybePokemon = this.findById(id);
		
		if (maybePokemon.isPresent()) {
			Pokemon existingPokemon = maybePokemon.get();
			
			modelMapper.map(data, existingPokemon);
			
			return Optional.of(this.pokemonRepository.save(existingPokemon));
		}
		
		return maybePokemon;
	}// return the Optional created pokemon or empty Optional

	

	

	

	

	

	
	
	
	
}
