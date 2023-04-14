package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public String creatDoctor(@RequestBody @Valid DoctorRecord data){
        repository.save(new Doctor(data));
        System.out.println(data);
        return "Doctor created successfully!";
    }
}
