package com.example.crudproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String status;
    private String descricao;
    private String prioridade;
    private String datelimit;

    public Tarefa() {}

    public Tarefa(long id, String nome, String status, String descricao, String prioridade, String datelimit) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.datelimit = datelimit;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getDatelimit() {
        return datelimit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", prioridade=" + prioridade +
                ", data limite=" + datelimit +
                ", descrição=" + descricao +
                '}';
    }
}
