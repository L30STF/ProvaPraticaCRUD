package com.example.ProvaPratica.Repositories;

import com.example.ProvaPratica.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
