package oscar.io.pokedexbackend.pokemon;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pokemon") // auto create table pokemon
public class Pokemon {
	// Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // ~ AUTO_INCREMENT from 1
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@Column
	private Integer hp;
	
	@Column
	private String url;
	
	@Column
	private Long evolutionId;
	
	
	//// Getter & Setter
	public Long getId() {
		return id;
	}

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
	public Pokemon() {}
	
	public Pokemon(String name, String type, Integer hp, String url, Long evolutionId) {
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.url = url;
		this.evolutionId = evolutionId;
	}

	
}
