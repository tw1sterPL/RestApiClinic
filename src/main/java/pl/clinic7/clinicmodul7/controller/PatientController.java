package pl.clinic7.clinicmodul7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.clinic7.clinicmodul7.exception.PatientNotFoundException;
import pl.clinic7.clinicmodul7.model.Patient;
import pl.clinic7.clinicmodul7.repository.PatientRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientRepository patientsRepository;

    @Autowired
    public PatientController(PatientRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    @GetMapping
    public List<Patient> findAll() {
        return patientsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable String id) throws PatientNotFoundException {
        return patientsRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Patient create(@Valid @RequestBody Patient patient) {
        return patientsRepository.create(patient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Patient patient, @PathVariable String id) {
        patientsRepository.update(patient,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        patientsRepository.delete(id);
    }
}
