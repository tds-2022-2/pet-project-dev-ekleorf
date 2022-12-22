package br.com.ekleorf.tds.projetos.Service;


import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ekleorf.tds.projetos.Model.Projeto;
import br.com.ekleorf.tds.projetos.Persistence.ProjetoRepository;

@Service
public class ProjetoService {
    private final ProjetoRepository projetoRepository;
    public ProjetoService(ProjetoRepository projetoRepository){
        this.projetoRepository = projetoRepository;
    }
    
    public Projeto criarProjeto(Projeto projeto){
        projeto.setID();
        //projeto.setParticipantes();
        this.projetoRepository.salvar(projeto);
        return projeto;
    }

    public ArrayList<Projeto> listarProjetos(){
        return projetoRepository.listarProjetos();
    }

    public void deletarProjeto(UUID id) {
        this.projetoRepository.deletarProjeto(id);
    }

    public Projeto alterarStatusProjeto(UUID id, Projeto projeto) {
        Projeto p = this.buscaPorID(id);
        p.setStatus(projeto.getStatus());
        
        this.projetoRepository.salvar(p);
        return p;
    }

    public Projeto buscaPorID(UUID id){
        return this.projetoRepository.buscaPorID(id);

    }
    public void alterarProjeto(UUID id,Projeto projeto) {
        Projeto p = this.buscaPorID(id);
        p.setProjeto(projeto.getNome());
        p.setStatus(projeto.getStatus());
        
        this.projetoRepository.salvar(p);
    }
}
