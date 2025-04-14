package com.example.ProvaPratica.Model;

import com.example.ProvaPratica.Model.TrabalhoModel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PessoaModel {

        @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;


      private String nome;

      @OneToMany
      private List<TrabalhoModel> trabalhos = new ArrayList<>();


      public PessoaModel() {}

     public PessoaModel(String nome) {
                this.nome = nome;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TrabalhoModel> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<TrabalhoModel> trabalhos) {
        this.trabalhos = trabalhos;
    }
}