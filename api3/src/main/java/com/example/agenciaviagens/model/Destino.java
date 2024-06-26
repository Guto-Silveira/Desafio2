package com.example.agenciaviagens.model;

import jakarta.persistence.*;

@Entity
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String localizacao;
    private String descricao;
    public int getAvaliacaoMedia() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getNumeroAvaliacoes() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setAvaliacaoMedia(double novaAvaliacaoMedia) {
		// TODO Auto-generated method stub
		
	}
	public void setNumeroAvaliacoes(int i) {
		// TODO Auto-generated method stub
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    // Getters e Setters
}
