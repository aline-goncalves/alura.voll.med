package med.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.address.AddressRecord;

public record DoctorRecord(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        String phone,
        @NotNull
        SpecialtyEnum specialty,
        @NotNull @Valid
        AddressRecord address
) {}