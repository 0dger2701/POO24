package com.example.crudproject.controller;

import com.example.crudproject.model.Tarefa;
import com.example.crudproject.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> getAllTasks() {
        return tarefaService.findAll();
    }

    @PostMapping
    public Tarefa createTask(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }

    @PutMapping
    public Tarefa editTask(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }

    @PostMapping("/{id}/a_fazer")
    public Tarefa iniciar(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.findById(id);
        tarefa.setStatus("A Fazer");
        return tarefaService.save(tarefa);
    }

    @PutMapping("/{id}/avancarStatus")
    public Tarefa avancarStatus(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.findById(id);
        if (tarefa == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        }

        switch (tarefa.getStatus()) {
            case "A Fazer":
                tarefa.setStatus("Andamento");
                break;
            case "Andamento":
                tarefa.setStatus("Concluido");
                break;
            default:
                return tarefa;  // Se o status não for "A Fazer" ou "Andamento", retorna a tarefa sem alteração
        }
        return tarefaService.save(tarefa);  // Salvando e retornando a tarefa atualizada
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tarefaService.deleteById(id);
    }


}
