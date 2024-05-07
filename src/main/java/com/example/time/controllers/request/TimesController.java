package com.example.time.controllers.request;

import com.example.time.model.Times;
import com.example.time.repository.TimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/times")
public class TimesController {
    @Autowired
    private TimesRepository repository;

    @PostMapping
    public ResponseEntity<Times> criar (@Valid @RequestBody Times time) {

        this.repository.save(time);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Times> obter(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity removerTime(@PathVariable UUID id) {
        Optional<Times> optUsuario = this.repository.findById(id);

        //Caso não ache o usuário, retornar um 404
        if (optUsuario.isEmpty() == true) {
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Times times = optUsuario.get();

        repository.delete(times);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Times> atualizaUsuario(@PathVariable("id") UUID id, @RequestBody Times timeNovo) {
        Optional<Times> optUsuario = this.repository.findById(id);

        //Caso não ache o usuário, retornar um 404
        if (optUsuario.isEmpty() == true) {
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Times time = optUsuario.get();
        if(timeNovo.getNome() != null && !timeNovo.getNome().isEmpty()){
            time.setNome(timeNovo.getNome());
        }
        if (timeNovo.getEstadio() != null && !timeNovo.getEstadio().isEmpty()) {
            time.setEstadio(timeNovo.getEstadio());
        }

        repository.save(time);

        return new ResponseEntity(time, HttpStatus.OK);
    }
}
