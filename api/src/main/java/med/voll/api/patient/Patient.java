package med.voll.api.patient;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.address.Address;
import med.voll.api.utils.ValidateValues;

@Table(name = "patients")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    @Embedded
    private Address address;
    private Boolean active;

    public Patient(PatientCreateRecord data){
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.phone = data.phone();
        this.address = new Address(data.address());
        this.active = true;
    }

    public void updatePatient(PatientUpdateRecord data) {
        ValidateValues validateValues = new ValidateValues();
        this.name = validateValues.returnValidString(data.name(), this.name);
        this.phone = validateValues.returnValidString(data.phone(), this.phone);
        this.address = validateValues.returnValidAddress(data.address(), this.address);
    }

    public void deletePatient(){
        this.active = false;
    }
}
