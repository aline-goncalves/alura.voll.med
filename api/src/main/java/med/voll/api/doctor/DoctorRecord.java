package med.voll.api.doctor;

import med.voll.api.address.AddressRecord;

public record DoctorRecord(String name, String email, String crm, SpecialtyEnum specialty, AddressRecord address) {
}
