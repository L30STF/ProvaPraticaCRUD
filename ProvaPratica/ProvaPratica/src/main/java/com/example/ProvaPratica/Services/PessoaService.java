package com.example.ProvaPratica.Services;


import com.example.ProvaPratica.Model.PessoaModel;
import com.example.ProvaPratica.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {


        @Autowired
        private PessoaRepository pessoaRepository;

        public PessoaModel criarPessoa(PessoaModel pessoa) {
            return pessoaRepository.save(pessoa);
        }

        public List<PessoaModel> listarPessoas() {
            return pessoaRepository.findAll();
        }

        public Optional<PessoaModel> buscarPessoa(Long id) {
            return pessoaRepository.findById(id);
        }

        public PessoaModel atualizarPessoa(Long id, PessoaModel pessoaAtualizada) {
            Optional<PessoaModel> pessoaExistente = pessoaRepository.findById(id);
            if (pessoaExistente.isPresent()) {
                PessoaModel pessoa = pessoaExistente.get();
                pessoa.setNome(pessoaAtualizada.getNome());
                return pessoaRepository.save(pessoa);
            }
            throw new RuntimeException("Pessoa não encontrada");
        }

        public void deletarPessoa(Long id) {
            Optional<PessoaModel> pessoa = pessoaRepository.findById(id);
            if (pessoa.isPresent()) {
                if (!pessoa.get().getTrabalhos().isEmpty()) {
                    throw new RuntimeException("Não é possível deletar uma pessoa com trabalhos associados");
                }
                pessoaRepository.deleteById(id);
            } else {
                throw new RuntimeException("Pessoa não encontrada");
            }
        }
}

