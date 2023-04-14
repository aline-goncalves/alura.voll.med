package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping
    @RequestMapping("/all")
    public List<DoctorListRecord> listAllDoctors(){
        return repository.findAll().stream().map(DoctorListRecord::new).toList();
    }

    @GetMapping
    public Page<DoctorListRecord> listAllDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return repository.findAll(pageable).map(DoctorListRecord::new);
    }
}
