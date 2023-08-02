package oscar.io.pokedexbackend.pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

//DTO: Data Transfer Object
public class CreatePokemonDTO {
	
	
	@NotBlank
	String name;
	
	@NotBlank
	String type;
	
	@NotNull
	@Positive
	Integer hp;
	
	@NotBlank
	String url;
	
	@Positive
	Long evolutionId;
	
	//// Getter & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getEvolutionId() {
		return evolutionId;
	}

	public void setEvolutionId(Long evolutionId) {
		this.evolutionId = evolutionId;
	}

	
	// constructors
	 
	public CreatePokemonDTO(String name, String type, Integer hp, String url, Long evolutionId) {
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.url = url;
		this.evolutionId = evolutionId;
	}
}
