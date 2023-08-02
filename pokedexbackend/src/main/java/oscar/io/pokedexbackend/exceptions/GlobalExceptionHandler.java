package oscar.io.pokedexbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	// @ExceptionHandler listens to application, when NotFoundException class is throw, execute this method
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex){
//		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
