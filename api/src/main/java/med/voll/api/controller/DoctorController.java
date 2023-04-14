package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import med.voll.api.doctor.*;
import org.springframework.data.domain.*;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public String creatDoctor(@RequestBody @Valid DoctorCreateRecord data){
        repository.save(new Doctor(data));
        return "Doctor created successfully!";
    }

    @GetMapping("/all")
    public List<DoctorListRecord> listAllDoctors(){
        return repository.findAll().stream().map(DoctorListRecord::new).toList();
    }

    @GetMapping("/all-with-pagination")
    public Page<DoctorListRecord> listAllDoctors(@PageableDefault( sort = {"name"}) Pageable pageable){
        return repository.findAll(pageable).map(DoctorListRecord::new);
    }

    @GetMapping
    public Page<DoctorListRecord> listAllActiveDoctors(@PageableDefault( sort = {"name"}) Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(DoctorListRecord::new);
    }

    @PutMapping
    @Transactional
    public String updateDoctor(@RequestBody @Valid DoctorUpdateRecord data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateDoctor(data);
        return "Doctor updated successfully!";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteDoctor(@NotNull @PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.deleteDoctor();
        return "Doctor deleted successfully!";
    }
}
