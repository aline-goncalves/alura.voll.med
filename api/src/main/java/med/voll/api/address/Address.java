package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.utils.ValidateValues;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String cep;
    private String city;
    private String state;
    private String complement;
    private String number;

    public Address(AddressRecord address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.city = address.city();
        this.state = address.state();
        this.complement = address.complement();
        this.number = address.number();
    }

    public void updateAddress(AddressRecord address) {
        ValidateValues validateValues = new ValidateValues();
        this.street = validateValues.returnValidString(address.street(), this.street);
        this.neighborhood = validateValues.returnValidString(address.neighborhood(), this.neighborhood);
        this.cep = validateValues.returnValidString(address.cep(), this.cep);
        this.city = validateValues.returnValidString(address.city(), this.city);
        this.state = validateValues.returnValidString(address.state(), this.state);
    }
}
