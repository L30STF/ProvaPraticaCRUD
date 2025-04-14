package com.example.ProvaPratica.Services;

import com.example.ProvaPratica.Model.TrabalhoModel;
import com.example.ProvaPratica.Repositories.TrebalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrebalhoRepository trabalhoRepository;

    public TrabalhoModel criarTrabalho(TrabalhoModel trabalho) {
        return trabalhoRepository.save(trabalho);
    }

    public List<TrabalhoModel> listarTrabalhos() {
        return trabalhoRepository.findAll();
    }

    public Optional<TrabalhoModel> buscarTrabalho(Long id) {
        return trabalhoRepository.findById(id);
    }

    public TrabalhoModel atualizarTrabalho(Long id, TrabalhoModel trabalhoAtualizado) {
        Optional<TrabalhoModel> trabalhoExistente = trabalhoRepository.findById(id);
        if (trabalhoExistente.isPresent()) {
            TrabalhoModel trabalho = trabalhoExistente.get();
            trabalho.setTitulo(trabalhoAtualizado.getTitulo());
            trabalho.setPessoa(trabalhoAtualizado.getPessoa());
            return trabalhoRepository.save(trabalho);
        }
        throw new RuntimeException("Trabalho não encontrado");
    }

    public void deletarTrabalho(Long id) {
        Optional<TrabalhoModel> trabalho = trabalhoRepository.findById(id);
        if (trabalho.isPresent()) {
            trabalhoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Trabalho não encontrado");
        }
    }
}

