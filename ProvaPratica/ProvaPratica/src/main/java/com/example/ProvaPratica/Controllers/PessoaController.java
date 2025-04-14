package com.example.ProvaPratica.Controllers;

import com.example.ProvaPratica.Model.PessoaModel;
import com.example.ProvaPratica.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaModel criarPessoa(@RequestBody PessoaModel pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @GetMapping
    public List<PessoaModel> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> buscarPessoa(@PathVariable Long id) {
        return pessoaService.buscarPessoa(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public PessoaModel atualizarPessoa(@PathVariable Long id, @RequestBody PessoaModel pessoa) {
        return pessoaService.atualizarPessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}