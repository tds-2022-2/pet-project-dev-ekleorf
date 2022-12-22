package br.com.ekleorf.tds.projetos.Model;

import java.util.UUID;

public class Colaborador {
    private UUID id;
    private String nome;

    public Colaborador(String nome){
        this.id =UUID.randomUUID();
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    public UUID getID(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
}
