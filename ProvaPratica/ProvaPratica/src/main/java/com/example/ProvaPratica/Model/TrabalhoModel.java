package com.example.ProvaPratica.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "/trabalho")
public class TrabalhoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String titulo;

        @ManyToOne
        @JoinColumn(name = "pessoa_id", nullable = false)
        private PessoaModel pessoa;


        public TrabalhoModel() {}

        public TrabalhoModel(String titulo, PessoaModel pessoa) {
            this.titulo = titulo;
           this.pessoa = pessoa;
        }
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public PessoaModel getPessoa() {
            return pessoa;
        }

        public void setPessoa(PessoaModel pessoa) {
            this.pessoa = pessoa;
        }
}

