package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.address.Address;
import med.voll.api.utils.ValidateValues;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String phone;
    @Enumerated(EnumType.STRING)
    private SpecialtyEnum specialty;
    @Embedded
    private Address address;
    private Boolean active;

    public Doctor(DoctorCreateRecord data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.phone = data.phone();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
        this.active = true;
    }

    public void updateDoctor(DoctorUpdateRecord data) {
        ValidateValues validateValues = new ValidateValues();
        this.name = validateValues.returnValidString(data.name(), this.name);
        this.phone = validateValues.returnValidString(data.phone(), this.phone);
        this.address = validateValues.returnValidAddress(data.address(), this.address);
    }

    public void deleteDoctor() {
        this.active = false;
    }
}
