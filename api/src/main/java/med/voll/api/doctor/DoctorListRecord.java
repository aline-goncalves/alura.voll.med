package med.voll.api.doctor;

public record DoctorListRecord(Long id, String name, String email, String crm, SpecialtyEnum specialty) {
    public DoctorListRecord(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
