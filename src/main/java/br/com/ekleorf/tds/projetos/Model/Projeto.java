package br.com.ekleorf.tds.projetos.Model;

//import java.util.ArrayList;
import java.util.UUID;

public class Projeto {
    private UUID id;
    private String nome;
    private Boolean status = true;
    //private ArrayList<Colaborador> participantes;

   
    public Projeto(){

    }
    public Projeto(String nome){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.status = true;
        //this.participantes = new ArrayList<Colaborador>();
    }
    
    public String getNome(){
        return this.nome;
    }
    public UUID getId(){
        return this.id;
    }
    /*public ArrayList<Colaborador> getParticipantes(){
        //return this.participantes;
    }
    */
    public void setProjeto(String nome){
        this.nome = nome;

    }
    public void setID(){
        this.id = UUID.randomUUID();
    }
    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }
   /*  public void setParticipantes(){

        this.participantes.add(new Colaborador("Nome Colaborador"));
    }*/
}
