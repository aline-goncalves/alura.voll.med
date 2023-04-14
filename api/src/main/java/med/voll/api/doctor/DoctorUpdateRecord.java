package med.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressRecord;

public record DoctorUpdateRecord(
        @NotNull
        Long id,
        String name,
        String phone,
        @Valid
        AddressRecord address
) {}