package com.nickfera.tarefas.tarefas_api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nome", nullable = false, unique = false, length = 50)
  private String nome;

  @Column(name = "data_entrega", nullable = false, unique = false)
  private String dataEntrega;

  @Column(name = "responsavel", nullable = false, unique = false, length = 50)
  private String responsavel;

  public Integer getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDataEntrega() {
    return this.dataEntrega;
  }

  public void setDataEntrega(String dataEntrega) {
    this.dataEntrega = dataEntrega;
  }

  public String getResponsavel() {
    return this.responsavel;
  }

  public void setResponsavel(String responsavel) {
    this.responsavel = responsavel;
  }
}
