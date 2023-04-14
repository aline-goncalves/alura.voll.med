package med.voll.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.address.AddressRecord;

public record PatientRecord(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String cpf,
        @NotNull @Valid
        AddressRecord address
) {}
