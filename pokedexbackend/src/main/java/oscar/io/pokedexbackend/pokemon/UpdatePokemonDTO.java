package oscar.io.pokedexbackend.pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

public class UpdatePokemonDTO {
	
	@Pattern(regexp = "^(?=\\S).*$", message="Content cannot be an empty string") // should not content only white space
	String name;
	
	@Pattern(regexp = "^(?=\\S).*$", message="Content cannot be an empty string") // should not content only white space
	String type;
	
	@NotNull
	@Positive
	Integer hp;
	
	@Pattern(regexp = "^(?=\\S).*$", message="Content cannot be an empty string") // should not content only white space
	String url;
	
	Long evolutionId;

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
	
	
}
