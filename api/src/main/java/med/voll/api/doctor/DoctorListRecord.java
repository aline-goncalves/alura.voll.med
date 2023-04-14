package med.voll.api.doctor;

public record DoctorListRecord(String name, String email, String crm, SpecialtyEnum specialty) {
    public DoctorListRecord(Doctor doctor){
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
