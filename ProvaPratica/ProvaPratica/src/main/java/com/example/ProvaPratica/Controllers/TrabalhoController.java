package com.example.ProvaPratica.Controllers;



import com.example.ProvaPratica.Model.TrabalhoModel;
import com.example.ProvaPratica.Services.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public TrabalhoModel criarTrabalho(@RequestBody TrabalhoModel trabalho) {
        return trabalhoService.criarTrabalho(trabalho);
    }

    @GetMapping
    public List<TrabalhoModel> listarTrabalhos() {
        return trabalhoService.listarTrabalhos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoModel> buscarTrabalho(@PathVariable Long id) {
        return trabalhoService.buscarTrabalho(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public TrabalhoModel atualizarTrabalho(@PathVariable Long id, @RequestBody TrabalhoModel trabalho) {
        return trabalhoService.atualizarTrabalho(id, trabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTrabalho(@PathVariable Long id) {
        trabalhoService.deletarTrabalho(id);
        return ResponseEntity.noContent().build();
    }
}
