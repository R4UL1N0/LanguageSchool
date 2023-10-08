package br.com.raulino.LanguageSchool.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.raulino.LanguageSchool.models.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> treatDuplicateEntry(DataIntegrityViolationException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("User already exists", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> treat404(EntityNotFoundException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "404");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> treatGeneralException(Exception e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
