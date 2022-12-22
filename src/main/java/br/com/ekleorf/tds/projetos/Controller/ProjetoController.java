package br.com.ekleorf.tds.projetos.Controller;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekleorf.tds.projetos.Model.Projeto;
import br.com.ekleorf.tds.projetos.Service.ProjetoService;


@RestController
@RequestMapping(
    path="/api/projetos",
    produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE
)
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService){
        this.projetoService = projetoService;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(path = "/oi")
    String oi(){
        return "Oi Spring e APIs";
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarProjeto(@RequestBody Projeto projeto){
        this.projetoService.criarProjeto(projeto);

    }
    @GetMapping
    public ArrayList<Projeto> listarProjetos(){

        return projetoService.listarProjetos();
    }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable(value = "id") UUID id){
        this.projetoService.deletarProjeto(id);
    }

    @PatchMapping("/{id}")
    public Projeto alterarStatusProjeto(@PathVariable(value = "id") UUID id,@RequestBody Projeto projeto){
        Projeto projetoAtualizado = this.projetoService.alterarStatusProjeto(id,projeto);
        return projetoAtualizado;
    }

    @PutMapping("/{id}")
    public void alterarProjeto(@PathVariable(value = "id") UUID id,@RequestBody Projeto projeto){
        this.projetoService.alterarProjeto(id,projeto);
    }
    
}
