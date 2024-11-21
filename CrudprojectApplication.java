package com.example.crudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudprojectApplication.class, args);
	}

}
/*
{
    "nome": "Tarefa Exemplo",
    "status": "A Fazer",
    "prioridade": "alta",
    "datelimit": "amanhã",
    "descricao": "descrição"
}
GET http://localhost:8080/tarefa/1

POST http://localhost:8080/tarefa

PUT http://localhost:8080/tarefa/1/avancarStatus

DELETE http://localhost:8080/tarefa/1



 */