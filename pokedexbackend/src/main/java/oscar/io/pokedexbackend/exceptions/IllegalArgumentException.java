package oscar.io.pokedexbackend.exceptions;

public class IllegalArgumentException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public IllegalArgumentException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	} 
}
