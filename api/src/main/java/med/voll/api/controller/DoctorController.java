package med.voll.api.controller;

import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    public String creatDoctor(@RequestBody DoctorRecord data){
        repository.save(new Doctor(data));
        System.out.println(data);
        return "Doctor created successfully!";
    }
}
