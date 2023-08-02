package oscar.io.pokedexbackend.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DataIntegrityViolationException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	} 
}
