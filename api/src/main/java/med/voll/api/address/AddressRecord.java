package med.voll.api.address;

import jakarta.validation.constraints.*;

public record AddressRecord(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String complement,
        String number
) {}