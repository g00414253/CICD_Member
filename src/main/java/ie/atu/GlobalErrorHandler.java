package ie.atu;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> showErrors(MethodArgumentNotValidException ex){
        Map<String, String> errorList = new HashMap<>();
        for(FieldError error : ex.getFieldErrors()){
            String errorName = error.getField();
            String errMessage = error.getDefaultMessage();
            errorList.put(errorName, errMessage);
        }
        return ResponseEntity.status(400).body(errorList);
    }
}
