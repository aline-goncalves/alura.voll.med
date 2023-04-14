package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.*;

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
        if(address.street() != null) {
            this.street = address.street();
        }

        if(address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }

        if(address.cep() != null) {
            this.cep = address.cep();
        }

        if(address.city() != null) {
            this.city = address.city();
        }

        if(address.state() != null) {
            this.state = address.state();
        }
    }
}
