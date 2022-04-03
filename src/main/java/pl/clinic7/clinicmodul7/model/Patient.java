package pl.clinic7.clinicmodul7.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.pl.PESEL;

public record Patient(
        @NotNull(message= "Pole nie może być puste")
        String id,
        @NotNull(message= "Pole nie może być puste")
        String name,
        @NotNull(message= "Pole nie może być puste")
        String surname,
        @NotNull(message= "Pole nie może być puste")
        @Size(min = 11, max = 11)
        String telNumber,
        @NotNull(message= "Pole nie może być puste")
        @PESEL
        String PESEL,
        @Size(min = 50, max = 255)
        String comment)
{
}
