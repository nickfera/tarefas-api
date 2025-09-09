package com.nickfera.tarefas.tarefas_api;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
public class TarefaController {
  @Autowired
  private TarefaRepository tarefaRepository;

  @PostMapping("/tarefas")
  public Tarefa create(@Validated @RequestBody Tarefa createTarefa) {
    Tarefa tarefa = tarefaRepository.save(createTarefa);

    return tarefa;
  }

  @GetMapping("/tarefas/{id}")
  public Tarefa findById(@PathVariable Integer id) {
    return tarefaRepository.findById(id).get();
  }

  @GetMapping("/tarefas")
  public List<Tarefa> findAll() {
    return tarefaRepository.findAll();
  }

  @PatchMapping("/tarefas/{id}")
  public Tarefa updateById(@PathVariable Integer id, @RequestBody Tarefa updateTarefa) {
    Tarefa tarefaDb = tarefaRepository.findById(id).get();

    if (Objects.nonNull(updateTarefa.getNome()) && !"".equalsIgnoreCase(updateTarefa.getNome())) {
      tarefaDb.setNome(updateTarefa.getNome());
    }

    if (Objects.nonNull(updateTarefa.getDataEntrega()) && !"".equalsIgnoreCase(updateTarefa.getDataEntrega())) {
      tarefaDb.setDataEntrega(updateTarefa.getDataEntrega());
    }

    if (Objects.nonNull(updateTarefa.getResponsavel()) && !"".equalsIgnoreCase(updateTarefa.getResponsavel())) {
      tarefaDb.setResponsavel(updateTarefa.getResponsavel());
    }

    return tarefaRepository.save(tarefaDb);
  }

  @DeleteMapping("/tarefas/{id}")
  public void deleteById(@PathVariable Integer id) {
    tarefaRepository.deleteById(id);
  }
}
