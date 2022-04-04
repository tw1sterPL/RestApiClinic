package pl.clinic7.clinicmodul7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.clinic7.clinicmodul7.exception.PatientNotFoundException;
import pl.clinic7.clinicmodul7.model.Patient;
import pl.clinic7.clinicmodul7.service.PatientServices;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientServices patientsServices;

    public PatientController( PatientServices patientsServices) {
        this.patientsServices = patientsServices;
    }

    @GetMapping
    public List<Patient> findAll() {
        return patientsServices.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable String id) throws PatientNotFoundException {
        return patientsServices.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Patient create(@Valid @RequestBody Patient patient) {
        return patientsServices.create(patient);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Patient patient, @PathVariable String id) {
        patientsServices.update(patient,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        patientsServices.delete(id);
    }
}
