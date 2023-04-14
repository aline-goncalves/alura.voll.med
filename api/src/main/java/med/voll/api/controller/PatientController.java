package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
