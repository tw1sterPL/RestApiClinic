package pl.clinic7.clinicmodul7.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception { }


