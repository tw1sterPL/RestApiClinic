package pl.clinic7.clinicmodul7.repository;

import org.springframework.stereotype.Repository;
import pl.clinic7.clinicmodul7.exception.PatientNotFoundException;
import pl.clinic7.clinicmodul7.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PatientRepository {

    List<Patient> patients;

//    public PatientRepository(){
//        patients.add(new Patient(UUID.randomUUID().toString(),
//                "default",
//                """
//                    default
//                 """,
//                "default",
//                "default",
//                 "default"
//        ));
//    }

    public PatientRepository(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> findAll() {
        return patients;
    }

    public Patient findById(String id) throws PatientNotFoundException {
        return patients.stream().filter(patient -> patient.id().equals(id)).findFirst().orElseThrow(PatientNotFoundException::new);
    }

    public Patient create(Patient patient) {
        patients.add(patient);
        return patient;
    }

    public void update(Patient patient, String id) {
        Patient existing = patients.stream().filter(s -> s.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono"));
        int i = patients.indexOf(existing);
        patients.set(i, patient);
    }

    public void delete(String id) {
        patients.removeIf(patient -> patient.id().equals(id));
    }
}
