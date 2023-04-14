package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import med.voll.api.patient.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public String creatPatient(@RequestBody @Valid PatientCreateRecord data){
        repository.save(new Patient(data));
        System.out.println(data);
        return "Patient created successfully!";
    }

    @GetMapping
    @RequestMapping("/all")
    public List<PatientListRecord> listAllPatients(){
        return repository.findAll().stream().map(PatientListRecord::new).toList();
    }

    @GetMapping
    public Page<PatientListRecord> listAllActivePatients(@PageableDefault( sort = {"name"}) Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(PatientListRecord::new);
    }

    @PutMapping
    @Transactional
    public String updatePatient(@RequestBody @Valid PatientUpdateRecord data){
        var patient = repository.getReferenceById(data.id());
        patient.updatePatient(data);
        return "Patient updated successfully!";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletePatient(@NotNull @PathVariable Long id){
        var patient = repository.getReferenceById(id);
        patient.deletePatient();
        return "Patient deleted successfully!";
    }
}
