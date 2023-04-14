package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public String creatPatient(@RequestBody @Valid PatientRecord data){
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
    public Page<PatientListRecord> listAllPatients(Pageable pageable){
        return repository.findAll(pageable).map(PatientListRecord::new);
    }
}
