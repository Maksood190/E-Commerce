package com.project.Exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




@RestControllerAdvice
public class GlobleExceptionHandle {

	@ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleAddressNotFoundException(AddressNotFoundException ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCartNotFoundException(CartNotFoundException ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(MyOrderNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleMyOrderNotFoundException(MyOrderNotFoundException ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFoundException(ProductNotFoundException ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("error", ex.getMessage());
        response.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
}
