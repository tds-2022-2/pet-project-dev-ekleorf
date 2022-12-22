package br.com.ekleorf.tds.projetos.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.ekleorf.tds.projetos.Model.Projeto;

@Repository
public class ProjetoRepository {
    private final Map<UUID,Projeto> map = new HashMap<>();
    public void salvar(Projeto projeto){
        System.out.println("Entrou no salvar: "+projeto.getNome());
        map.put(projeto.getId(), projeto);
    }
    public ArrayList<Projeto> listarProjetos() {
        return new ArrayList<Projeto>(map.values());
    }
    public void deletarProjeto(UUID id) {
        map.remove(id);
    }
    public Projeto atualizarStatusProjeto(UUID id) {
        Projeto projeto = map.get(id);
        projeto.setStatus(null);
        return null;
    }
    public Projeto editarProjeto(Projeto projeto) {
        System.out.println("Nome atualizado: "+projeto.getNome());
        return map.replace(projeto.getId(), projeto);
    }
    public Projeto buscaPorID(UUID id){
        return map.get(id);
    }
}
